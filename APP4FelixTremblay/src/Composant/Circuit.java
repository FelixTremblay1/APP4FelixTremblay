package Composant;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Circuit extends Composant{

    protected ArrayList<Composant> composants;

    public Circuit(ArrayList<Composant> composants){
        setComposants(composants);
    }

    public ArrayList<Composant> getComposants() {
        return composants;
    }

    public void setComposants(ArrayList<Composant> composants) {
        this.composants = composants;
    }
}
