package src.testing;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestFileLoader {

    public TestCase loader(String filename) {
        filename = "test-value-file.txt";
        LinkedHashMap<String, StringBuilder> mainStages = this.parseGameData(filename);
        //durnig coding
        return null;
    }

    private LinkedHashMap<String, StringBuilder> parseGameData(String filename) {
        LinkedHashMap<String, StringBuilder> dataMap = new LinkedHashMap<>();
        String currentSectionKey = null;
        StringBuilder currentSectionContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("./valuesfiles/"+filename))) {
            FileWriter fileWriter = new FileWriter("testWriting.txt");

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("__")) {
                    System.out.println("Found section: " + line);
                    if (currentSectionKey != null) {
                        dataMap.put(currentSectionKey, currentSectionContent);
                        System.out.println("Added section: " + currentSectionKey + " with content: " + currentSectionContent);
                    }
                    currentSectionKey = line.trim();
                    currentSectionContent = new StringBuilder();
                } else {
                    currentSectionContent.append(line).append("\n");
                }
            }
            // Add the last section
            if (currentSectionKey != null) {
                dataMap.put(currentSectionKey, currentSectionContent);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return dataMap;
    }
}
