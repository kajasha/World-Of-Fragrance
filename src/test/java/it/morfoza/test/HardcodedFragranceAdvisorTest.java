package it.morfoza.test;

import it.morfoza.karo.perfume.Fragrance;
import it.morfoza.karo.perfume.HardcodedFragranceAdvisor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class HardcodedFragranceAdvisorTest {

    @Test
    public void shouldNotFindPerfumeThatItNotOnTheList() {
        // Given

        HardcodedFragranceAdvisor advisor = new HardcodedFragranceAdvisor();

        // When
        List<Fragrance> fragrances = advisor.findMatchingPerfume("tralala");


        // Then
        assertTrue(fragrances.isEmpty());
    }

    @Test
    public void shouldFindPerfumeThatItOnTheList() {
        // Given

        HardcodedFragranceAdvisor advisor = new HardcodedFragranceAdvisor();
        Fragrance fragrance = new Fragrance("tralala", "skarpetki, cebula", "gender");
        advisor.addFragrance(fragrance);


        // When
        List<Fragrance> fragrances = advisor.findMatchingPerfume("tralala");


        // Then
        assertTrue(fragrances.contains(fragrance));
    }
}
