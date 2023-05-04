package org.jdbc.persistence.dao;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Accion {
    int id;
    String name;
    int costo;
    String grupo;

    String tiporecurso;

    public Accion() {

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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getTiporecurso() {
        return tiporecurso;
    }

    public void setTiporecurso(String tiporecurso) {
        this.tiporecurso = tiporecurso;
    }

    public Accion(ResultSet result) {
        try {
            this.id = result.getInt("idacciones");
            this.name = result.getString("displayname");
            this.costo = result.getInt("costo");
            this.grupo = result.getString("grupo");
            this.tiporecurso = result.getString("recursocosto");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
