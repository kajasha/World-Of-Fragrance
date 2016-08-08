import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfume {
    public static void main(String[] args) {

        List<Fragrance> allPerfume = new ArrayList<>();
        allPerfume.add(new Fragrance("Calvin Kleine Euphoria", "Głowa- zielona nuta, owoc granatu, kaki Serce - lotos, orchidea, Podstawa - piżmo, mahoń, nuty śmietany, bursztyn, fiołek"));
        allPerfume.add(new Fragrance("Calvin Kleine IN2U", "Głowa - różowy grapefruit, liście czarnej porzeczki, bergamotka sycylijska, Serce - kaktus, orchidea, Podstawa - cedr, bursztyn, wanilia"));
        allPerfume.add(new Fragrance("DKNY Be Delicious", "Głowa - grejpfrut, ogórek, magnolia, Serce - róża, konwalia, tuberoza, fiołek, zielone jabłko, Podstawa - bursztyn, drzewo sandałowe, nuty drzew"));
        allPerfume.add(new Fragrance("Giorgio Armani", "Głowa - liście czarnej porzeczki, Serce - frezja, róża, Podstawa - wanilia, ambroxan, paczuli, nuty drzew"));
        allPerfume.add(new Fragrance("Calvin Kleine Summer", "Głowa - cytryna, mojito, zielone jabłko, imbir, limonka, Serce - jałowiec, Tahitiańska gardenia, guajawa, Podstawa - mleczko kokosowe, cedr, mech"));



        Scanner wejscie = new Scanner(System.in);

        System.out.println("Jaki jest Twój ulubiony zapach?");

        String ingredients = wejscie.nextLine();

        List<Fragrance> allMatchPerfume = new ArrayList<>();
        for (Fragrance fragrance: allPerfume) {
            if (fragrance.ingredients.contains(ingredients)) {
                allMatchPerfume.add(fragrance);
            }
        }
        System.out.println(allMatchPerfume);
    }

}
