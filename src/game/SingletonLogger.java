package src.game;
import java.util.logging.Logger;

public class SingletonLogger {
    private static Logger logger = null;

    private SingletonLogger() {
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(SingletonLogger.class.getName());
        }
        return logger;
    }
}
