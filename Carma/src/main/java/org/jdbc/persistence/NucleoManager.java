package org.jdbc.persistence;

import org.jdbc.persistence.dao.Nucleo;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NucleoManager {

    public static List<Nucleo> findAll(Connection con) {

        try (Statement stm=con.createStatement()) {

            ResultSet result=stm.executeQuery("SELECT * FROM nucleos");

            result.beforeFirst();

            List<Nucleo> nucleos=new ArrayList<>();

            while (result.next()) {
                nucleos.add(new Nucleo(result));
            }

            return nucleos;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
