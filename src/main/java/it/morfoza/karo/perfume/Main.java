package it.morfoza.karo.perfume;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("text")) {
            PerfumeConsole.mainConsole(args);
        } else {
            PerfumeSpringBoot.runOnSpring(args);
        }
    }
}
