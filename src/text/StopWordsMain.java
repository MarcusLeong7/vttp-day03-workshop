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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StopWordsMain {
    public static void main(String[] args) throws FileNotFoundException, IOException {
            
        String inputFile = args[0];

        //Open inputFile for reading
        Reader reader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader (reader);

        //Define StopWords regex pattern
        // \\b is to account for word boundaries and \\s? is to suppress optional trailing white space
        String StopWordsPattern = 
        "\\b(i|me|my|myself|we|our|ours|ourselves|you|your|yours|yourself|yourselves|he|him|his|himself|she|her|hers|herself|it|its|itself|they|them|their|theirs|themselves|what|which|who|whom|this|that|these|those|am|is|are|was|were|be|been|being|have|has|had|having|do|does|did|doing|a|an|the|and|but|if|or|because|as|until|while|of|at|by|for|with|about|against|between|into|through|during|before|after|above|below|to|from|up|down|in|out|on|off|over|under|again|further|then|once|here|there|when|where|why|how|all|any|both|each|few|more|most|other|some|such|no|nor|not|only|own|same|so|than|too|very|s|t|can|will|just|don|should|now)\\b\\s?";

        //Complie the regex pattern
        Pattern p = Pattern.compile(StopWordsPattern,Pattern.CASE_INSENSITIVE);

        // To store transformed output String line;
        StringBuilder transformedText = new StringBuilder();

        String line = "x";
        while ((line = bufferedReader.readLine()) != null) {
            
            //Match 
            Matcher m = p.matcher(line);
            String transformed = m.replaceAll(" ").toLowerCase().trim();

            //If line is null, we have reached the EOF
            if (null == line)
                break;

            // Append the transformed line to the result
            transformedText.append(transformed).append("\n");

        }

        //Close the files
        reader.close();

        System.out.println(transformedText.toString().trim());


    }
    
}
