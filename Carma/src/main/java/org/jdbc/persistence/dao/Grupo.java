package org.jdbc.persistence.dao;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Grupo {
    int id;
    String name;

    public Grupo() {

    }

    public Grupo(ResultSet result) {
        try {
            this.id = result.getInt("idnucleos");
            this.name = result.getString("displayname");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
