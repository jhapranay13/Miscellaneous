package DesingPattern.Behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * When dealing with entire Hirrerachy
 * Can Centralize operation or logic accross
 * Accumulate State
 *
 * Adding new Concrete Element is Hard
 * Requires new Methods
 * It breaks encapsulation
 *
 */
interface ComputerPart {
    void accept(ComputerPartVisitor visitor);
}

interface ComputerPartVisitor {
    void visit(ComputerScreen screen);
    void visit(ComputerKeyboard keyboard);
    void visit(ComputerMouse mouse);
}

class ComputerScreen implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class ComputerKeyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class ComputerMouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class Computer implements ComputerPart {
    List<ComputerPart> list = new ArrayList<>();

    @Override
    public void accept(ComputerPartVisitor visitor) {

        for (ComputerPart part : list) {
            part.accept(visitor);
        }
    }
}

class ComputerVisitor implements ComputerPartVisitor {


    @Override
    public void visit(ComputerScreen screen) {
        System.out.println("Visited screen");
    }

    @Override
    public void visit(ComputerKeyboard keyboard) {
        System.out.println("Visited keyboard");
    }

    @Override
    public void visit(ComputerMouse mouse) {
        System.out.println("Visited mouse");
    }
}

public class VisitorPattern {

    public static void main(String args[]) {
        Computer computer = new Computer();
        computer.list.add(new ComputerScreen());
        computer.list.add(new ComputerMouse());
        computer.list.add(new ComputerKeyboard());
        computer.accept(new ComputerVisitor());
    }
}
