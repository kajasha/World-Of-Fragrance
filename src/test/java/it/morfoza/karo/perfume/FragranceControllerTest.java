package it.morfoza.karo.perfume;

import org.junit.Test;
import org.springframework.ui.Model;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FragranceControllerTest {
    @Test
    public void testFragranceController() {

        FragranceAdvisor advisor = mock(FragranceAdvisor.class);
        FragranceController fragranceController = new FragranceController(advisor);

        // when
        String result = fragranceController.fragrance();

        // then
        assertEquals("fragrance", result);
    }

    @Test
    public void testFragranceController2() {
        FragranceAdvisor advisor = mock(FragranceAdvisor.class);

        List<Fragrance> fragrances = mock(List.class);
        when(fragrances.isEmpty()).thenReturn(false);


        when(advisor.findMatchingPerfume("cebula")).thenReturn(fragrances);
        FragranceController fragranceController = new FragranceController(advisor);

        Model model = mock(Model.class);


        String result = fragranceController.worldoffragrance("cebula", model);

        assertEquals("result", result);

    }



}