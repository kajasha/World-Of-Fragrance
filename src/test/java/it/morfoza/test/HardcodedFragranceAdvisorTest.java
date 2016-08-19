package it.morfoza.test;

import it.morfoza.karo.perfume.Fragrance;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HardcodedFragranceAdvisorTest {

    @Test
    public void should() {

        String search = null;

        List<Fragrance> allPerfume = new ArrayList<>();
        allPerfume.add(new Fragrance("Calvin Kleine Euphoria", "Głowa- zielona nuta, owoc granatu, kaki Serce - lotos, orchidea, Podstawa - piżmo, mahoń, nuty śmietany, bursztyn, fiołek"));
        allPerfume.add(new Fragrance("Calvin Kleine IN2U", "Głowa - różowy grapefruit, liście czarnej porzeczki, bergamotka sycylijska, Serce - kaktus, orchidea, Podstawa - cedr, bursztyn, wanilia"));
        allPerfume.add(new Fragrance("DKNY Be Delicious", "Głowa - grejpfrut, ogórek, magnolia, Serce - róża, konwalia, tuberoza, fiołek, zielone jabłko, Podstawa - bursztyn, drzewo sandałowe, nuty drzew"));
        allPerfume.add(new Fragrance("Giorgio Armani", "Głowa - liście czarnej porzeczki, Serce - frezja, róża, Podstawa - wanilia, ambroxan, paczuli, nuty drzew"));
        allPerfume.add(new Fragrance("Calvin Kleine Summer", "Głowa - cytryna, mojito, zielone jabłko, imbir, limonka, Serce - jałowiec, Tahitiańska gardenia, guajawa, Podstawa - mleczko kokosowe, cedr, mech"));

        List<Fragrance> allMatchPerfume = new ArrayList<>();
        for (Fragrance fragrance : allPerfume) {
            if (fragrance.matches(search)) {
                allMatchPerfume.add(fragrance);
            }

        }

    }
}
