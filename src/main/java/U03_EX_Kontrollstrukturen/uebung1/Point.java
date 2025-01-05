package U03_EX_Kontrollstrukturen.uebung1;

public class Point {
    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getQuadrant(){
        if (this.x > 0 && this.y > 0){
            return 1;
        } else if (this.x < 0 && this.y > 0){
            return 2;
        } else if (this.x < 0 && this.y < 0){
            return 3;
        } else if (this.x > 0 && this.y < 0){
            return 4;
        } else {
            return 0;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
