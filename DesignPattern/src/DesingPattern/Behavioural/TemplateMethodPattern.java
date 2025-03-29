package DesingPattern.Behavioural;

/**
 *
 *  n abstract class exposes defined way(s)/template(s) to execute its methods.
 *  Its subclasses can override the method implementation as per need but the invocation
 *  is to be in the same way as defined by an abstract class.
 *  This pattern comes under behavior pattern category.
 *
 *
 */
abstract class  AbstractInterest {
    public final int calc() {
        return amount() * interset() * time();
    }

    protected abstract int time();

    protected abstract int interset();

    protected abstract int amount();
}

class SimpleCalculation extends AbstractInterest {

    @Override
    protected int time() {
        return 2;
    }

    @Override
    protected int interset() {
        return 3;
    }

    @Override
    protected int amount() {
        return 4;
    }
}

class ExpensiveCalculation extends AbstractInterest {

    @Override
    protected int time() {
        return 200;
    }

    @Override
    protected int interset() {
        return 30;
    }

    @Override
    protected int amount() {
        return 40;
    }
}

public class TemplateMethodPattern {
    public static void main(String args[]) {
        SimpleCalculation simpleCalculation = new SimpleCalculation();
        ExpensiveCalculation expensiveCalculation = new ExpensiveCalculation();
        System.out.println(simpleCalculation.calc());
        System.out.println(expensiveCalculation.calc());
    }
}
