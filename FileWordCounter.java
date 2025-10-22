package sectionb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileWordCounter
 * -----------------
 * Counts words, characters and lines in a text file.
 *
 * Usage:
 *   java sectionb.FileWordCounter <file-path>
 */
public class FileWordCounter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java sectionb.FileWordCounter <file-path>");
            return;
        }

        String filePath = args[0];
        int wordCount = 0, charCount = 0, lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    String[] words = trimmed.split("\\s+");
                    wordCount += words.length;
                }
            }

            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);
            System.out.println("Lines: " + lineCount);

        } catch (IOException e) {
            System.err.println("Error: File not found or cannot be read. " + e.getMessage());
        }
    }
}
