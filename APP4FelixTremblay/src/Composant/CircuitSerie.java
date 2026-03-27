package Composant;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CircuitSerie extends Circuit{

    public CircuitSerie(ArrayList<Composant> composants){
        super(composants);
    }

    @Override
    public double calculerResistance() {
        double sommeRes = 0;
        for (int i = 0 ; i<this.composants.size() ; i++){
            sommeRes += composants.get(i).calculerResistance();
        }
        return sommeRes;
    }
}
