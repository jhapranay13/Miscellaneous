package DesingPattern.Creational;

/**
 * java.lang.Runtime as Egar Singleton
 *
 * Database Pool, Windows Manager, Help Library, Constants
 * To avoid breakage from Reflections use enum
 * To avoid Serilization
 *
 * class Singleton implements Serializable {
 *
 *     // public instance initialized when loading the class
 *     public static Singleton instance = new Singleton();
 *
 *     private Singleton()
 *     {
 *         // private constructor
 *     }
 *
 *     // implement readResolve method
 *     protected Object readResolve() { return instance; }
 * }
 *
 * To avoid Cloning
 * class Singleton implements Cloneable {
 *
 *     // public instance initialized when loading the class
 *     public static Singleton instance = new Singleton();
 *
 *     private Singleton()
 *     {
 *         // private constructor
 *     }
 *
 *     @Override
 *     protected Object clone()
 *         throws CloneNotSupportedException
 *     {
 *         throw new CloneNotSupportedException();
 *     }
 * }
 *
 */

class Singleton {
    private static Singleton globalObject;
    private String str;

    private Singleton(String str) {
        this.str = str;
    }

    public static Singleton createInstance() {

        if (globalObject == null) {
            globalObject = new Singleton("Only One created");
        }
        return globalObject;
    }

    public String getStr() {
        return str;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.createInstance();
        Singleton obj2 = Singleton.createInstance();
        System.out.println(obj1.getStr());
        System.out.println(obj2.getStr());
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
    }
}
