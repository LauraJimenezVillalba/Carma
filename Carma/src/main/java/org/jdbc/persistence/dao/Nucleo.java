package org.jdbc.persistence.dao;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Nucleo {
    int id;
    String name;
    int salud;
    String grupo;

    public Nucleo() {

    }

    public Nucleo(ResultSet result) {
        try {
            this.id = result.getInt("idnucleos");
            this.name = result.getString("displayname");
            this.salud = result.getInt("salud");
            this.grupo = result.getString("grupo");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
