package DesingPattern.Structural;

/**
 *
 * legacy system to new system or two seperate system
 * Also known as wrapper
 * Combine unrelated classes with incompatable interface
 * inheritance or refernce can be used for adaptee
 *
 * won't work for classes with many subclasses
 *
 *
 * InputStreamReader
 *
 */

class LegacyRectangle {
    public int getSide() {
        return 10;
    }
}

class Rectangle {
    public int get() {
        return 5;
    }
}

class LegacyAdapter extends Rectangle {
    LegacyRectangle lr;

    public LegacyAdapter(LegacyRectangle lr) {
        this.lr = lr;
    }

    @Override
    public int get() {
        return lr.getSide();
    }
}

public class AdapterPattern {
    public static void main(String args[]) {
        LegacyRectangle lr = new LegacyRectangle();
        Rectangle rect = new LegacyAdapter(lr);
        System.out.println(rect.get());
    }
}
