package puzzles;

/**
 * Created by ravibol on 4/20/16.
 */
public class Pair {
    private final char a;
    private final char b;
    private int day = 0;

    public  Pair(char a, char b) {
        this.a = a;
        this.b = b;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return a + "" + b;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        Pair that = (Pair) obj;
        return that.a == this.a || that.b == this.a || that.a == this.b || that.b == this.b;
    }

    @Override
    public int hashCode() {
        return day;
    }
}
