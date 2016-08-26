package it.morfoza.karo.perfume;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FragranceRowMapper implements RowMapper<Fragrance> {

    @Override
    public Fragrance mapRow(ResultSet resultSet, int i) throws SQLException{

        String name = resultSet.getString("name");
        String ingredients = resultSet.getString("ingredients");
        String type = resultSet.getString("type");
        Fragrance fragrance = new Fragrance(name, ingredients, type);
        return fragrance;

    }

}
