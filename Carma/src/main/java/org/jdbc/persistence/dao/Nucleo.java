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

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
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
