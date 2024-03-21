package src.game;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class SingletonLogger {
    public static Logger logger = null;

    static {
        logger = Logger.getLogger(SingletonLogger.class.getName());
        Handler[] handlers = logger.getParent().getHandlers();
        for (Handler handler : handlers) {
            logger.getParent().removeHandler(handler);
        }
        CustomConsoleHandler handler = new CustomConsoleHandler();
        handler.setFormatter(new CustomFormatter());
        logger.addHandler(handler);
    }

    private SingletonLogger() {
    }
}