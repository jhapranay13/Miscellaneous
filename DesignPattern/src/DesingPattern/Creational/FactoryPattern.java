package DesingPattern.Creational;

/**
 *
 *
 * When a class doesn't know what sub-classes will be required to create
 * When a class wants that its sub-classes specify the objects to be created.
 * When the parent classes choose the creation of objects to its sub-classes.
 *
 * NumberFormat has getInstance
 *
 */
abstract class Plan {
    protected double rate;

    public double calculateBill(int unit) {
        return unit * rate;
    }
    abstract void setRate();

}

class DomesticPlan extends Plan {

    @Override
    void setRate() {
        rate = 0.5;
    }
}

class CommercialPlan extends Plan {

    @Override
    void setRate() {
        rate = 0.7;
    }
}

class PlanFactory {
    public Plan getPlan(String plan) {

        if (plan != null && plan.equals("DOMESTIC")) {
            return new DomesticPlan();
        } else {
            return new CommercialPlan();
        }
    }
}
public class FactoryPattern {
    public static void main(String args[]) {
        PlanFactory factory = new PlanFactory();
        Plan p = factory.getPlan(null);
        p.setRate();
        double ans = p.calculateBill(27);
        System.out.println(ans);

    }
}
