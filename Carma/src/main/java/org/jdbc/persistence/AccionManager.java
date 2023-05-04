package org.jdbc.persistence;

import org.jdbc.persistence.dao.Accion;
import org.jdbc.persistence.dao.Nucleo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccionManager {

    public static List<Accion> findAll(Connection con) {

        try (Statement stm=con.createStatement()) {

            ResultSet result=stm.executeQuery("SELECT * FROM acciones");

            result.beforeFirst();

            List<Accion> acciones=new ArrayList<>();

            while (result.next()) {
                acciones.add(new Accion(result));
            }

            return acciones;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
