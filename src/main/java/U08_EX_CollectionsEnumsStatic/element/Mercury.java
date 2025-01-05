package U08_EX_CollectionsEnumsStatic.element;

public class Mercury extends Element {

    protected final double BOILING_POINT = -39.0;
    protected final double MELTING_POINT = 357.0;
    protected final boolean TOXICITY = true;

    public Mercury() {
        super ("Mercury", "Hg");
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

    @Override
    public String toString() {
        return super.toString() + "\n" + "Toxicity: " + TOXICITY;
    }

    public boolean isToxic(){
        return TOXICITY;
    }
}
