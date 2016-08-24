package it.morfoza.test;

import it.morfoza.karo.perfume.Fragrance;
import it.morfoza.karo.perfume.FragranceAdvisor;
import it.morfoza.karo.perfume.FragranceController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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

        //given
        FragranceAdvisor advisor = mock(FragranceAdvisor.class);

        List<Fragrance> fragrances = mock(List.class);
        when(fragrances.isEmpty()).thenReturn(false);


        when(advisor.findMatchingPerfume("cebula")).thenReturn(fragrances);
        FragranceController fragranceController = new FragranceController(advisor);

        Model model = mock(Model.class);

        //when

        String result = fragranceController.worldoffragrance("cebula", model);

        //then
        assertEquals("result", result);

    }

/*
    ArgumentCaptor<Fragrance> captor = ArgumentCaptor.forClass(Product.class);
    verify(metoda).dodaj(captor.capture());
    classa konstruktor =captor. ();

    */

    @Test
    public void shouldCheckSthTest() {

        FragranceAdvisor advisor = mock(FragranceAdvisor.class);
        FragranceController fragranceController = new FragranceController(advisor);



        //when


        String view = fragranceController.createnewfragrance("a", "b");

        //then
        assertEquals("redirect:/fragrancenotfound?error=Zbyt+kr%C3%B3tka+nazwa", view);

    }

    @Test
    public void shouldCheckIfCreateNewFragranceWorkCorrectlyTest() {
        FragranceAdvisor advisor = mock(FragranceAdvisor.class);
        FragranceController f = new FragranceController(advisor);

        //when

        String view = f.createnewfragrance("aaa", "bbb");

        //then

        assertEquals("redirect:/newfragrance", view);
    }

    @Test
    public void shouldCheckAdvisor() {
        FragranceAdvisor advisor = mock(FragranceAdvisor.class);
        FragranceController f = new FragranceController(advisor);


        String view = f.createnewfragrance("aaa", "bbb");


        verify(advisor).addFragrance(new Fragrance("aaa", "bbb"));
    }

    @Test
    public void shouldCheckNewFragrance() {
        FragranceAdvisor advisor = mock(FragranceAdvisor.class);
        FragranceController ff = new FragranceController(advisor);

        String result = ff.newfragrance();

        assertEquals("createNewFragrance", result);
    }

    @Test
    public void shouldCheckFindMatchingPerfumeOnAdvisor() {

        // given
        FragranceAdvisor advisor = mock(FragranceAdvisor.class);
        FragranceController fc = new FragranceController(advisor);

        Model model = mock(Model.class);
        List<Fragrance> fragrancesList = mock(List.class);

        when(advisor.findMatchingPerfume("")).thenReturn(fragrancesList);

        // when
        fc.all(model);

        // then
        verify(model).addAttribute("allPerfumes", fragrancesList);


    }
}