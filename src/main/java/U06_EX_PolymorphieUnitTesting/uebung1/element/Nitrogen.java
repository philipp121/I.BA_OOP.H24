package U06_EX_PolymorphieUnitTesting.uebung1.element;

public class Nitrogen extends Element {

    protected final double BOILING_POINT = -210.0;
    protected final double MELTING_POINT = -196.0;

    public Nitrogen() {
        super("Nitrogen", "N");
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

}




