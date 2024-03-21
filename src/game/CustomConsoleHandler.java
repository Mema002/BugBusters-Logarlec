package src.game;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CustomConsoleHandler extends ConsoleHandler {
    @Override
    public void publish(LogRecord record) {
        if (record.getLevel().intValue() >= Level.WARNING.intValue()) {
            System.err.println(getFormatter().format(record));        }
        if (getFormatter() != null) {
            System.out.print(getFormatter().format(record));
        }
    }
}