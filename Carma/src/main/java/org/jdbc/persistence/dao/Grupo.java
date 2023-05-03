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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
