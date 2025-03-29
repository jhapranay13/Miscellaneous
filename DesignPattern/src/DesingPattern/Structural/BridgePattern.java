package DesingPattern.Structural;

/**
 *
 * Allows to loosely couple and implementation from interface
 *
 * DriverManager.getConnection(new Driver())
 *
 */

interface DrawApi {
    public void draw();
}

class RedCircle implements DrawApi {

    @Override
    public void draw() {
        System.out.println("Red Circle");
    }
}

class GreenCircle implements DrawApi {

    @Override
    public void draw() {
        System.out.println("Green Circle");
    }
}

abstract class Shape {
    DrawApi drawApi;

    public void setDrawApi(DrawApi drawApi) {
        this.drawApi = drawApi;
    }

    public abstract void draw();
}

class CircleBridge extends Shape {

    @Override
    public void draw() {
        drawApi.draw();
    }
}

public class BridgePattern {
    public static void main(String args[]) {
        DrawApi red = new RedCircle();
        DrawApi green = new GreenCircle();
        Shape bridge = new CircleBridge();
        bridge.setDrawApi(red);
        bridge.draw();
        bridge.setDrawApi(green);
        bridge.draw();
    }
}
