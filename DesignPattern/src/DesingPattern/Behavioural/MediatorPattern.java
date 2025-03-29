package DesingPattern.Behavioural;

/**
 *
 *
 * Decouples Communication Between Objects.
 * Changes many to many interactions to one to many
 * Object Communication is abstracted
 *
 * All objects are notified if one object changes
 *
 *
 */
class Fan {
    Mediator mediator;
    boolean isOn = false;

    public void turnOn() {
        mediator.startPower();
        isOn = true;
    }

    public void turnOff() {
        mediator.stopPower();
        isOn = false;
    }
}

class PowerSource {
    Mediator mediator;
    boolean isOn = false;

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }
}

class Button {
    Mediator mediator;

    public void press() {
        mediator.press();
    }
}

class Mediator {
    PowerSource powerSource = new PowerSource();
    Fan fan = new Fan();
    Button button = new Button();

    public Mediator() {
        this.powerSource.mediator = this;
        this.fan.mediator = this;
        this.button.mediator = this;
    }

    public void startPower() {
        powerSource.turnOn();
    }

    public void stopPower() {
        powerSource.turnOff();
    }

    public void press() {

        if (fan.isOn) {
            fan.turnOff();
        } else {
            fan.turnOn();
        }
    }
}

public class MediatorPattern {

    public static void main(String args[]) {
        Mediator mediator = new Mediator();
        PowerSource ps = mediator.powerSource;
        Fan fan = mediator.fan;
        Button button = mediator.button;
        System.out.println("Is Fan on >> " + fan.isOn);
        System.out.println("Is Power Source  on >> " + mediator.powerSource.isOn);
        button.press();
        System.out.println("Is Fan on >> " + fan.isOn);
        System.out.println("Is Power Source  on >> " + mediator.powerSource.isOn);
        button.press();
        System.out.println("Is Fan on >> " + fan.isOn);
        System.out.println("Is Power Source  on >> " + mediator.powerSource.isOn);
    }
}
