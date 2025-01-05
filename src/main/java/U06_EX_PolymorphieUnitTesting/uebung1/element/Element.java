package U06_EX_PolymorphieUnitTesting.uebung1.element;

public abstract class Element {
    private final String name;
    private final String symbol;

    public Element(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public abstract String getAggregateState(int temperature);

    public abstract double getBoilingPoint();

    public abstract double getMeltingPoint();

    public String getName() {
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Chemical Letter: " + getSymbol() + "\n"
                + "Boiling Point: " + getBoilingPoint() + "\n"
                + "Melting Point: " + getMeltingPoint();
    }
}
