package org.jdbc.persistence;

import org.jdbc.persistence.dao.Grupo;
import org.jdbc.persistence.dao.Nucleo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GrupoManager {

    public List<Grupo> findAll(Connection con) {

        try (Statement stm=con.createStatement()) {

            ResultSet result=stm.executeQuery("SELECT * FROM grupos");

            result.beforeFirst();

            List<Grupo> grupos=new ArrayList<>();

            while (result.next()) {
                grupos.add(new Grupo(result));
            }

            return grupos;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
