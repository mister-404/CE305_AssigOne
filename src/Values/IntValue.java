package Values;

public class IntValue extends NumberValue{
    private final int val;

    public IntValue(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val+"";
    }

    public int getVal() {
        return val;
    }
}
