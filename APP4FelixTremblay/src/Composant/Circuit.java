package Composant;

import java.lang.reflect.Array;

public abstract class Circuit extends Composant{

    protected Array<Composant> composants;

    public Circuit(Array<Composant> composants){
        setComposants(composants);
    }

    public Array<Composant> getComposants() {
        return composants;
    }

    public void setComposants(Array<Composant> composants) {
        this.composants = composants;
    }
}
