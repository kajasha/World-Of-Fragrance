package it.morfoza.karo.perfume;

import java.util.List;

public interface FragranceAdvisor {
    List<Fragrance> findMatchingPerfume(String search);

    void addFragrance(Fragrance fragrance);

    List<Fragrance> getAllPerfumes();
}
