import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfume {
    public static void main(String[] args) {

        Fragrance perfume1;
        Fragrance perfume2;
        Fragrance perfume3;
        Fragrance perfume4;
        Fragrance perfume5;


        perfume1 = new Fragrance("Calvin Kleine Euphoria", "Głowa- zielona nuta, owoc granatu, kaki Serce - lotos, orchidea, Podstawa - piżmo, mahoń, nuty śmietany, bursztyn, fiołek");
        perfume2 = new Fragrance("Calvin Kleine IN2U", "Głowa - różowy grapefruit, liście czarnej porzeczki, bergamotka sycylijska, Serce - kaktus, orchidea, Podstawa - cedr, bursztyn, wanilia");
        perfume3 = new Fragrance("DKNY Be Delicious", "Głowa - grejpfrut, ogórek, magnolia, Serce - róża, konwalia, tuberoza, fiołek, zielone jabłko, Podstawa - bursztyn, drzewo sandałowe, nuty drzew");
        perfume4 = new Fragrance("Giorgio Armani", "Głowa - liście czarnej porzeczki, Serce - frezja, róża, Podstawa - wanilia, ambroxan, paczuli, nuty drzew");
        perfume5 = new Fragrance("Calvin Kleine Summer", "Głowa - cytryna, mojito, zielone jabłko, imbir, limonka, Serce - jałowiec, Tahitiańska gardenia, guajawa, Podstawa - mleczko kokosowe, cedr, mech");

        List<Fragrance> allPerfume = new ArrayList<>();
        allPerfume.add(perfume1);
        allPerfume.add(perfume2);
        allPerfume.add(perfume3);
        allPerfume.add(perfume4);
        allPerfume.add(perfume5);


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
