package it.morfoza.karo.perfume;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DateBaseFragranceAdvisor implements FragranceAdvisor{

    private JdbcTemplate jdbcTemplate;

    public DateBaseFragranceAdvisor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public List<Fragrance> findMatchingPerfume(String search) {
        String searchForLike = "%" + search + "%";
        return jdbcTemplate.query("SELECT name, ingredients, type FROM products WHERE name LIKE ? OR ingredients LIKE ? ", new FragranceRowMapper(), searchForLike, searchForLike);
    }

    @Override
    public void addFragrance(Fragrance fragrance) {
        jdbcTemplate.update("INSERT INTO products(name, ingredients, type) VALUES (?, ?, ?)", fragrance.getName(), fragrance.getIngredients(), fragrance.getType());


    }
    @Override
    public List<Fragrance> getAllPerfumes() {
        return jdbcTemplate.query("SELECT name, ingredients, type FROM products", new FragranceRowMapper());
    }
}
