package CircuitApp;

import Composant.Composant;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CircuitApp {
    private static final char FSep = File.separatorChar;

    public static void main(String[] args) {
        System.out.println("Bonjour.");
        CircuitApp bob = new CircuitApp();
        int choix;
        boolean exit = true;
        CircuitBuilder cirBuild = new CircuitBuilder();
        do {
            System.out.println("Voici les fichiers jason disponibles pour la consultation.");
            String dir = System.getProperty("user.dir") + FSep + "src" + FSep + "donnees" + FSep + "fichiers_json";
            try {
                List<Path> paths = Files.walk(Paths.get(dir), 1)
                        .filter(Files::isRegularFile)
                        .filter(path -> path.getFileName().toString().endsWith(".json"))
                        .collect(Collectors.toList());
                for (int i = 0; i < paths.toArray().length; i++) {
                    System.out.println((i + 1) + ": " + paths.get(i).getFileName().toString());
                }
                System.out.println("Veuillez écrire le numéro de votre choix dans l'interface");
                choix = bob.getNumber(1, paths.toArray().length);
                for (int i = 0; i < paths.toArray().length; i++) {
                    if (i + 1 == choix) {
                        Composant composantSelectionne = cirBuild.construireCircuit(paths.get(i).toString());
                        System.out.println();
                        System.out.println("La résistance équivalente calculé du dossier "+ paths.get(i).getFileName().toString() +" est : " + composantSelectionne.calculerResistance());
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("1) Tester un autre fichier");
            System.out.println("2) Quitter");
            System.out.println("Veuillez écrire le numéro de votre choix dans l'interface");
            if (bob.getNumber(1, 2) == 2) {
                exit = false;
            }

        } while (exit);
        System.out.println("L'application a été arretée.");
    }

    private int getNumber(int valeurMin, int valeurMax) {
        Scanner sc = new Scanner(System.in);
            try {
                int number = sc.nextInt();
                if (number < valeurMin || number > valeurMax) {
                    throw new InputMismatchException();
                }
                return number;
            } catch (InputMismatchException e) {
                System.out.println("Cela n'est pas un choix valide. Veuillez prendre un numéro entre " + valeurMin + " et " + valeurMax + " inclusivement.");
                return getNumber(valeurMin, valeurMax);
            }
    }
}
