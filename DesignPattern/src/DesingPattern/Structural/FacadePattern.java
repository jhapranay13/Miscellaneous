package DesingPattern.Structural;

/**
 *
 * Loose Coupling
 * Subsystems can be used directly too
 * Abstract complex subsystem from clients
 *
 * disadvantage
 * Introduces extra layer
 *
 */
class Bill {
    private int amount;

    public Bill(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}

class BillingSystem {
    public Bill createBill(int amount) {
        return new Bill(amount);
    }
}

class InvoiceSystem {
    public void createInvoice(Bill bill) {
        System.out.println("Your bill is >> " + bill.getAmount());
    }
}

class Facade {
    public void getBill() {
        BillingSystem bs = new BillingSystem();
        InvoiceSystem is = new InvoiceSystem();
        Bill bill = bs.createBill(1000);
        is.createInvoice(bill);
    }
}

public class FacadePattern {

    public static void main(String ...args) {
        Facade fc = new Facade();
        fc.getBill();
    }
}
