package it.morfoza.test;

import groovy.transform.ASTTest;
import org.junit.Assert;
import org.junit.Test;

public class AssertionTest {
    @Test
            public void should() {

        //Given
        Grupa grupa = new Grupa();

        grupa.dodajDobregoUcznia();
        grupa.dodajZlegoUcznia();

        //when

        int[] faktyczneOceny = grupa.ocenUczniow();



        //then

        int[] oczekiwaneOceny = {5, 2};


        Assert.assertArrayEquals("Oceny się różnią", oczekiwaneOceny, faktyczneOceny);


    }
}
