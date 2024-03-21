package src.game;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;

public class CustomConsoleHandler extends ConsoleHandler {
    @Override
    public void publish(LogRecord record) {
        if (getFormatter() != null) {
            System.out.print(getFormatter().format(record));
        }
    }
}