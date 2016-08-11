package it.morfoza.karo.perfume;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FragranceController {

    private List<Fragrance> allPerfume = new ArrayList<>();

    public FragranceController() {
        allPerfume.add(new Fragrance("Calvin Kleine Euphoria", "Głowa- zielona nuta, owoc granatu, kaki Serce - lotos, orchidea, Podstawa - piżmo, mahoń, nuty śmietany, bursztyn, fiołek"));
        allPerfume.add(new Fragrance("Calvin Kleine IN2U", "Głowa - różowy grapefruit, liście czarnej porzeczki, bergamotka sycylijska, Serce - kaktus, orchidea, Podstawa - cedr, bursztyn, wanilia"));
        allPerfume.add(new Fragrance("DKNY Be Delicious", "Głowa - grejpfrut, ogórek, magnolia, Serce - róża, konwalia, tuberoza, fiołek, zielone jabłko, Podstawa - bursztyn, drzewo sandałowe, nuty drzew"));
        allPerfume.add(new Fragrance("Giorgio Armani", "Głowa - liście czarnej porzeczki, Serce - frezja, róża, Podstawa - wanilia, ambroxan, paczuli, nuty drzew"));
        allPerfume.add(new Fragrance("Calvin Kleine Summer", "Głowa - cytryna, mojito, zielone jabłko, imbir, limonka, Serce - jałowiec, Tahitiańska gardenia, guajawa, Podstawa - mleczko kokosowe, cedr, mech"));
    }

    @RequestMapping("/")
    public String fragrance() { return "fragrance"; }


    @RequestMapping("/worldoffragrance")
    public String worldoffragrance(
            @RequestParam(value = "search") String search,
            @RequestParam(value = "operation", required = false, defaultValue = "search") String operation, Model model) {

        List<Fragrance> allMatchPerfume = new ArrayList<>();
        for (Fragrance fragrance: allPerfume) {
            if (fragrance.name.contains(search) || fragrance.ingredients.contains(search)) {
                allMatchPerfume.add(fragrance);
            }
        }

        model.addAttribute("resultOfOperation", allMatchPerfume);
        return "result";

    }


}
