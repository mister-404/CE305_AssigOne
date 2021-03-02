package Values;

public class FloatValue extends Value{
    private final float val;

    public FloatValue(float val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val+"";
    }

    public float getVal() {
        return val;
    }
}
