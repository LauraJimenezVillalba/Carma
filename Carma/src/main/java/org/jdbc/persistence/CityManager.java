package org.jdbc.persistence;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityManager {

    public List<City> findAll(Connection con) {

        try (Statement stm=con.createStatement()) {

            ResultSet result=stm.executeQuery("SELECT * FROM City");

            result.beforeFirst();

            List<City> cities=new ArrayList<>();

            while (result.next()) {
                cities.add(new City(result));
            }

            return cities;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<City> findByNameAndCountryCode(Connection con, String name, String countryCode) {

        try (PreparedStatement stm=con.prepareStatement("SELECT * FROM City WHERE name like ? AND countryCode = ?")) {

            stm.setString(1, "%" + name + "%");
            stm.setString(2, countryCode);

            ResultSet result=stm.executeQuery();

            result.beforeFirst();

            List<City> cities=new ArrayList<>();

            while (result.next()) {
                cities.add(new City(result));
            }

            return cities;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public City findById(Connection con, int id) {

        try (PreparedStatement stm=con.prepareStatement("SELECT * FROM City WHERE ID = ?")) {

            stm.setInt(1, id);

            ResultSet result=stm.executeQuery();

            result.beforeFirst();

            City city=null;

            while (result.next()) {
                city=new City(result);
            }

            return city;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public int save(Connection con, City city) {

        try (PreparedStatement stm=con.prepareStatement("insert into city (name,countryCode, district,population) values(?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {

            stm.setString(1, city.getName());
            stm.setString(2, city.getCountryCode());
            stm.setString(3, city.getDistrict());
            stm.setBigDecimal(4, city.getPopulation());

            stm.executeUpdate();

            ResultSet result = stm.getGeneratedKeys();

            int generatedId = 0;

            while (result.next()) {
                generatedId = result.getInt(1);
            }

            return generatedId;

        }

        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static void main(String[] args)
            throws
            SQLException,
            ClassNotFoundException {

        Connection con=new MySQLConnector().getMySQLConnection();

        City city=new City();

        city.setId(4080);
        city.setName("Abalan");
        city.setCountryCode("ESP");
        city.setDistrict("Andalusia");
        city.setPopulation(new BigDecimal("500000"));

        int id = new CityManager().save(con, city);

        City cityResult=new CityManager().findById(con, id);

        System.out.println(cityResult);

        con.close();
    }
}
