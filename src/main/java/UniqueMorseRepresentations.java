import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueMorseRepresentations {
    public static void main(String args[]){
        final String maps[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


        Stream<String> words = Arrays.stream(args);
        Stream<String> results = words.map(word -> {
            char[] cArr = word.toCharArray();
            String result = "";
            for(char c: cArr) {
                result += maps[c-'a'];
            }
            return result;
        });
        System.out.println("the result is : " +results.collect(Collectors.toSet()).size());
    }
}

