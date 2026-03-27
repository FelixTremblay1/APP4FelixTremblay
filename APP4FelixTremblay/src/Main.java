import Composant.CircuitSerie;
import Composant.Composant;
import Composant.Resistance;
import Composant.CircuitParallele;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Resistance res2 = new Resistance(2);
        Resistance res3 = new Resistance(3);
        Resistance res5 = new Resistance(5);
        Resistance res10 = new Resistance(10);
        ArrayList<Composant> composants1 = new ArrayList<>();
        composants1.add(res3);
        composants1.add(res2);
        composants1.add(res5);
        CircuitSerie cs1 = new CircuitSerie(composants1);
        System.out.println("test calculerResistance ");
        System.out.println("Circuit en series");
        System.out.println("Expected : 10 res = " + cs1.calculerResistance());
        ArrayList<Composant> composants2 = new ArrayList<>();
        composants2.add(cs1);
        composants2.add(res5);
        composants2.add(res2);
        CircuitSerie cs2 = new CircuitSerie(composants2);
        System.out.println("Expected : 17 res = " + cs2.calculerResistance());
        System.out.println("Circuit en parallele");
        CircuitParallele cp1 = new CircuitParallele(composants1);
        System.out.println("Expected : 0.96774193548387096774193548387097 res = "+cp1.calculerResistance());
        ArrayList<Composant> composants3 = new ArrayList<>();
        composants3.add(res10);
        composants3.add(res5);
        composants3.add(cp1);
        CircuitParallele cp2 = new CircuitParallele(composants3);
        System.out.println("Expected : 0.75 res = " + cp2.calculerResistance());
    }
}