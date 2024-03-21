package src.game;

import java.awt.*;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return record.getLevel() + ": " + record.getMessage() + "\n";
    }
}