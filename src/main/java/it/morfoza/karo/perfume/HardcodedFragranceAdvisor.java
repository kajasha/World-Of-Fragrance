package it.morfoza.karo.perfume;

import java.util.ArrayList;
import java.util.List;

public class HardcodedFragranceAdvisor implements FragranceAdvisor {

    private List<Fragrance> fragrances = new ArrayList<>();

    public HardcodedFragranceAdvisor() {
        fragrances.add(new Fragrance("Calvin Kleine Euphoria", "Głowa- zielona nuta, owoc granatu, kaki Serce - lotos, orchidea, Podstawa - piżmo, mahoń, nuty śmietany, bursztyn, fiołek", "f"));
        fragrances.add(new Fragrance("Calvin Kleine IN2U", "Głowa - różowy grapefruit, liście czarnej porzeczki, bergamotka sycylijska, Serce - kaktus, orchidea, Podstawa - cedr, bursztyn, wanilia", "f"));
        fragrances.add(new Fragrance("DKNY Be Delicious", "Głowa - grejpfrut, ogórek, magnolia, Serce - róża, konwalia, tuberoza, fiołek, zielone jabłko, Podstawa - bursztyn, drzewo sandałowe, nuty drzew", "f"));
        fragrances.add(new Fragrance("Giorgio Armani", "Głowa - liście czarnej porzeczki, Serce - frezja, róża, Podstawa - wanilia, ambroxan, paczuli, nuty drzew", "f"));
        fragrances.add(new Fragrance("Calvin Kleine Summer", "Głowa - cytryna, mojito, zielone jabłko, imbir, limonka, Serce - jałowiec, Tahitiańska gardenia, guajawa, Podstawa - mleczko kokosowe, cedr, mech", "f"));

    }

    @Override
    public List<Fragrance> findMatchingPerfume(String search) {

        List<Fragrance> allMatchPerfume = new ArrayList<>();
        for (Fragrance fragrance : getAllPerfumes()) {
            if (fragrance.matches(search)) {
                allMatchPerfume.add(fragrance);
            }
        }
        return allMatchPerfume;
    }

    @Override
    public void addFragrance(Fragrance fragrance) {
        fragrances.add(fragrance);
    }

    @Override
    public List<Fragrance> getAllPerfumes() {
        return null;
    }
}
