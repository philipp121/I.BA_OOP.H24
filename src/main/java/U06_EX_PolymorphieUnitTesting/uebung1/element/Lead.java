package U06_EX_PolymorphieUnitTesting.uebung1.element;

public class Lead extends Element {

    protected final double BOILING_POINT = 327.5;
    protected final double MELTING_POINT = 1749;
    protected final boolean TOXICITY = true;

    public Lead() {
        super("Lead", "Pb");
    }

    @Override
    public String getAggregateState(int temperature) {
        if (temperature < getBoilingPoint()){
            return "solid";
        } else if (temperature < getMeltingPoint()){
            return "liquid";
        } else {
            return "gaseous";
        }
    }

    @Override
    public double getBoilingPoint() {
        return BOILING_POINT;
    }

    @Override
    public double getMeltingPoint() {
        return MELTING_POINT;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Toxicity: " + TOXICITY;
    }

    public boolean isToxic(){
        return TOXICITY;
    }


}
