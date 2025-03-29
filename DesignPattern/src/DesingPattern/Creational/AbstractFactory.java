package DesingPattern.Creational;

/**
 *
 * Returns factory
 *
 * extention of this pattern is difficult
 *
 * AbstractCollection Iterator method
 *
 * XMLDocumentBuilderFactory
 *
 */

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square");
    }
}

class RoundedRectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rounded Rectangle");
    }
}

class RoundedSquare implements Shape {

    @Override
    public void draw() {
        System.out.println("Rounded Square");
    }
}

abstract class AbstractFact {
    abstract Shape getShape(String shapeType) ;
}

class RoundedShapeFactory extends AbstractFact {

    @Override
    Shape getShape(String shapeType) {
        if (shapeType.equals("RECTANGLE")) {
            return new RoundedRectangle();
        } else {
            return new RoundedSquare();
        }
    }
}

class ShapeFactory extends AbstractFact {

    @Override
    Shape getShape(String shapeType) {
        if (shapeType.equals("RECTANGLE")) {
            return new Rectangle();
        } else {
            return new Square();
        }
    }
}

class FactoryProducer {
    public AbstractFact getFactory(boolean isRounded) {

        if (isRounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}

public class AbstractFactory {
    public static void main(String args[]) {
        FactoryProducer producer = new FactoryProducer();
        AbstractFact factory = producer.getFactory(false);
        factory.getShape("RECTANGLE").draw();
    }
}
