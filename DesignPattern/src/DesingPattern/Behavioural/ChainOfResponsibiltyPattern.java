package DesingPattern.Behavioural;

/**
 *
 * Multiple Objects Needs to Handle Request
 * isn't clear upfront who will handle the request
 * Request Handler should be dynamic
 *
 *
 */
abstract class  AbstractLogger {
    AbstractLogger abstractLogger;
    int level;

    public void setNextLogger(AbstractLogger logger) {
        abstractLogger = logger;
    }

    public abstract void writeLog(String message, int level);
}

class FileLogger extends AbstractLogger {

    @Override
    public void writeLog(String message, int level) {
        if (abstractLogger != null) {
            abstractLogger.writeLog(message, level);
        }

        if (level >= this.level) {
            System.out.println("File Logger :: >> " + message);
        }
    }
}

class ErrorLogger extends AbstractLogger {

    @Override
    public void writeLog(String message, int level) {
        if (abstractLogger != null) {
            abstractLogger.writeLog(message, level);
        }

        if (level >= this.level) {
            System.out.println("Error Logger :: >> " + message);
        }
    }
}

class DebugLogger extends AbstractLogger {

    @Override
    public void writeLog(String message, int level) {
        if (abstractLogger != null) {
            abstractLogger.writeLog(message, level);
        }

        if (level >= this.level) {
            System.out.println("Debug Logger :: >> " + message);
        }
    }
}

public class ChainOfResponsibiltyPattern {

    public static void main(String args[]) {
        ErrorLogger errorLogger = new ErrorLogger();
        errorLogger.level = 1;
        DebugLogger debugLogger = new DebugLogger();
        debugLogger.level = 2;
        FileLogger fileLogger = new FileLogger();
        fileLogger.level = 3;
        fileLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);
        fileLogger.writeLog("If level 1", 1);
        fileLogger.writeLog("If level 2", 2);
        fileLogger.writeLog("If level 3", 3);
    }
}
