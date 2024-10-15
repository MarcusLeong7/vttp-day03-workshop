package text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCountMain {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String inputFile = args[0];

        //Open inputFile for reading
        FileReader reader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader (reader);

        //Create a map
        Map<String, Integer> uniqueWords = new HashMap<>();

        String line = "x";
        while (null != line) {
            // Read a line
            line = bufferedReader.readLine();

            //If line is null, we have reached the EOF
            if (null == line)
                break;
            
            //System.out.printf(">>>>%s\n",line);
            //String transformed = line.toUpperCase();
            
            //bufferedWriter.write(line.toUpperCase() + "\n");

            String transformed = line.replaceAll("\\p{Punct}","").toLowerCase().trim();
            //System.out.printf(">>%s\n",transformed);

            for (String word:transformed.split(" ")) {

                int currentCount = 0;
                if(uniqueWords.containsKey(word))
                    currentCount = uniqueWords.get(word);
                
                currentCount++;

                uniqueWords.put(word,currentCount);
            }

                //Word is in the list
               //if (uniqueWords.containsKey(word)) {
                    //int currentCount = uniqueWords.get(word);
                    //currentCount++;
                   // uniqueWords.put(word,currentCount);
               //} else {
                // Word is not in the list
                   // uniqueWords.put(word,1);

              // }

            
        }

        //Close the files
        reader.close();
        
        System.out.println();
        for (String word: uniqueWords.keySet())
        System.out.printf("%s\t\t %d\n", word, uniqueWords.get(word));    
    }
        
    
}
