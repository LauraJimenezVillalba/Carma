package org.servlet;

import org.jdbc.persistence.MySQLConnector;
import org.jdbc.persistence.NucleoManager;
import org.jdbc.persistence.dao.Nucleo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MiServlet", urlPatterns ={"/mi-servlet"})
public class MiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException,
            IOException {
        PrintWriter writer = resp.getWriter();
        MySQLConnector connector = new MySQLConnector();
        Connection con = null;
        try {
            con = connector.getMySQLConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Nucleo> nucleoList = NucleoManager.findAll(con);
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
        writer.println("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">");
        writer.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>");
        writer.println("<link href=\"https://fonts.googleapis.com/css2?family=Lato&display=swap\" rel=\"stylesheet\">");
        writer.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css\">");
        writer.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/fixedheader/3.2.3/css/fixedHeader.dataTables.min.css\">");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div style=\"width:70%; float:left;\">");
        writer.println("<h1>Cartas de núcleo</h1>");
        writer.println("<table id=\"example\" class=\"display\">");
        writer.println("<thead>");
        writer.println("<tr>");
        writer.println("<th>ID</th>");
        writer.println("<th>Nombre</th>");
        writer.println("<th>Salud</th>");
        writer.println("<th>Grupo</th>");
        writer.println("<th></th>");
        writer.println("</tr>");
        writer.println("</thead>");
        writer.println("<tbody>");
        for (Nucleo nucleo : nucleoList) {
            writer.println("<tr>");
            writer.println("<td>" + nucleo.getId() + "</td>");
            writer.println("<td>" + nucleo.getName() + "</td>");
            writer.println("<td>" + nucleo.getSalud() + "</td>");
            writer.println("<td>" + nucleo.getGrupo() + "</td>");
            writer.println("<td><button onclick=\"cambiarImagen(" + nucleo.getId() + ")\">Ver</button></td>");
            writer.println("</tr>");
        }
        writer.println("</tbody>");
        writer.println("<tfoot></tfoot>");
        writer.println("</table>");
        writer.println("</div>");
        writer.println("<img id=\"miImagen\" src=\"images/n1.jpeg\" style=\"width:29%; float:right;\">");
        writer.println("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>");
        writer.println("<script src=\"https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js\"></script>");
        writer.println("<script src=\"https://cdn.datatables.net/fixedheader/3.2.3/js/dataTables.fixedHeader.min.js\"></script>");
        writer.println("<script src=\"js/tables.js\"></script>");
        writer.println("<script src=\"js/script.js\"></script>");
        writer.println("<script>");
        writer.println("function cambiarImagen(imageVariable) {");
        writer.println("document.getElementById('miImagen').src = 'images/n' + imageVariable + '.jpeg';");
        writer.println("}");
        writer.println("</script>");
        writer.println("</body>");
        writer.println("</html>");
    }
}

