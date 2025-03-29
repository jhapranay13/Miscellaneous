package DesingPattern.Structural;

/**
 *
 * When Extra Functionality is required.
 *
 * PlaceHolder to original Object
 *
 */

interface ExpensiveObj {
    void process();
}

class ExpensiveObjImpl implements ExpensiveObj {

    public ExpensiveObjImpl() {
        init();
    }

    public void init() {
        System.out.println("Loading from Disc");
    }

    @Override
    public void process() {
        System.out.println("Processing...");
    }
}

class ExpensiveObjectProxy implements ExpensiveObj {
    private static ExpensiveObj obj;

    @Override
    public void process() {

        if (obj == null) {
            obj = new ExpensiveObjImpl();
        }
        obj.process();
    }
}

public class ProxyPattern {


    public static void main(String args[]) {
        ExpensiveObjectProxy obj = new ExpensiveObjectProxy();
        obj.process();
        obj.process();
    }
}
