package Composant;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CircuitParallele extends Circuit{

    public CircuitParallele(ArrayList<Composant> composants){
        super(composants);
    }

    @Override
    public double calculerResistance() {
        double sommeResInverse = 0;
        for (int i = 0 ; i<this.composants.size() ; i++){
            sommeResInverse += 1/composants.get(i).calculerResistance();
        }
        return Math.pow(sommeResInverse,-1);
    }
}
