package U08_EX_CollectionsEnumsStatic.temperatur.element;

public class Nitrogen extends Element {

    protected final double BOILING_POINT = -210.0;
    protected final double MELTING_POINT = -196.0;

    public Nitrogen() {
        super("Nitrogen", "N");
    }

    @Override
    public AggregateState getAggregateState(int temperature) {
        if (temperature < getBoilingPoint()){
            return AggregateState.SOLID;
        } else if (temperature < getMeltingPoint()){
            return AggregateState.LIQUID;
        } else {
            return AggregateState.GAS;
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




