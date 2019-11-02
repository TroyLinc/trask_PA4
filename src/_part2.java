import java.util.Scanner;
import java.util.HashMap;
import java.io.*;


public class DuplicateCounter {

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> words = new HashMap<>(); //Where you will be saving your words

        Scanner dataFile = new Scanner(new FileReader("problem2.txt")); //Where file is your file
        while (dataFile.hasNextLine()) {

            String wrds = dataFile.next().toLowerCase();
            words.put(wrds, words.containsKey(wrds) ? words.get(wrds) + 1 : 1);
        }

        String build = "";
        for (String wrds : words.keySet()) {
            if (build != "") build += "\n";
            build += words.get(wrds) + " " + wrds;
        }

        String outputFile = "unique_word_counts.txt";
        BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
        output.write(String.join("\n", build));
        output.close();
        System.out.println("File '" + outputFile + "' created!");
    }
}