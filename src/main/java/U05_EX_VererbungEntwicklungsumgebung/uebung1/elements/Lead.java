package U05_EX_VererbungEntwicklungsumgebung.uebung1.elements;

public class Lead extends Element{
    public Lead(int boilingPoint, int meltingPoint, String name) {
        super(boilingPoint, meltingPoint, name);
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
}
