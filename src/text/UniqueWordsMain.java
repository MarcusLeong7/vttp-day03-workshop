package text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

public class UniqueWordsMain {
    public static void main(String[] args) throws FileNotFoundException, IOException {

       
            
        String inputFile = args[0];
        String outputFile = args[1];

        //Open inputFile for reading
        Reader reader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader (reader);

        // Open outputFile for writing
        Writer writer = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        //Create a set of String
        // <> - generics
        Set<String> uniqueWords = new HashSet<>();

        String line = "x";
        while (null != line) {
            // Read a line
            line = bufferedReader.readLine();

            //If line is null, we have reached the EOF
            if (null == line)
                break;

            String transformed = line.replaceAll("\\p{Punct}","").toLowerCase().trim();
            //System.out.printf(">>%s\n",transformed);

            for (String word:transformed.split(" "))
                uniqueWords.add(word);


        }

        //Write to file
        bufferedWriter.write("Unique words:\n" + uniqueWords);

        //Ensure all data is flushed to file
        bufferedWriter.flush();
        //Close the files
        reader.close();
        writer.close();

        System.out.printf("Unique words in %s: %d\n",inputFile, uniqueWords.size());

        for (String word:uniqueWords) {
            System.out.printf("%s, ", word);
        
        }

        System.out.println();


    }
    
}
