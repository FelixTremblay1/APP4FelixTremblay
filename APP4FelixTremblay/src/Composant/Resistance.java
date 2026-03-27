package Composant;

public class Resistance extends Composant{
    private double resistance;
    public final static double RESISTANCE_DEFAULT = 5;

    public Resistance(double resistance){
        setResistance(resistance);
    }

    public double calculerResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }
}
