package U05_EX_VererbungEntwicklungsumgebung.uebung1.elements;

public abstract class Element {
    private int boilingPoint;
    private int meltingPoint;
    private String name;

    public Element(int boilingPoint, int meltingPoint, String name) {
        this.boilingPoint = boilingPoint;
        this.meltingPoint = meltingPoint;
        this.name = name;
    }

    public abstract String getAggregateState(int temperature);

    public int getBoilingPoint() {
        return boilingPoint;
    }

    public int getMeltingPoint() {
        return meltingPoint;
    }

    public String getName() {
        return name;
    }
}
