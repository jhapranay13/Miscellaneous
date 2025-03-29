package DesingPattern.Structural;

/**
 *
 * Adding Funtionality to existing object without affecting other objects
 * Functionality can be taken away in the future
 *
 * More flexibility than inheritance
 * Functionality can be added as and when required
 *
 * Object identity cannot be used
 *
 * java.io.BufferedOutputStream
 *
 */

class Window {
    public void draw() {
        System.out.println("Window");
    }
}

class WiondowDecorator extends Window {
    private Window window;

    public WiondowDecorator(Window window) {
        this.window = window;
    }

    @Override
    public void draw() {
        window.draw();
    }
}

class IconWiondowDecorator extends Window {
    private Window window;

    public IconWiondowDecorator(Window window) {
        this.window = window;
    }

    @Override
    public void draw() {
        window.draw();
        System.out.println("Draw Icon");
    }
}

class ScrollWiondowDecorator extends Window {
    private Window window;

    public ScrollWiondowDecorator(Window window) {
        this.window = window;
    }

    @Override
    public void draw() {
        window.draw();
        System.out.println("Draw Scroll");
    }
}


public class DecoratorPattern {

    public static void main(String args[]) {
        Window window = new Window();
        IconWiondowDecorator iconWiondowDecorator = new IconWiondowDecorator(window);
        ScrollWiondowDecorator scrollWiondowDecorator = new ScrollWiondowDecorator(iconWiondowDecorator);
        scrollWiondowDecorator.draw();
    }
}
