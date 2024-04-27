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

        try (
                BufferedReader reader = new BufferedReader(new FileReader("src/testing/valuesfiles/"+filename));
                FileWriter fileWriter = new FileWriter("testWriting.txt", false);
            ) {

            String line;
            String currentSectionKey = null;
            StringBuilder currentSectionContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("__")) {
                    System.out.println("Found section: " + line);
                    if (currentSectionKey != null) {
                        dataMap.put(currentSectionKey, currentSectionContent);
                        System.out.println("Add section: " + currentSectionKey + " with content: " + currentSectionContent.toString());
                    }
                    currentSectionKey = line.trim();
                    currentSectionContent = new StringBuilder();
                } else {
                    currentSectionContent.append(line).append("\n");
                    System.out.println("Building section: " + currentSectionContent);
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

