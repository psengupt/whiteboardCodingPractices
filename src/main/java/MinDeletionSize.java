import java.util.stream.IntStream;

public class MinDeletionSize {
    public static void main(String[] A){
        final int[] del = {0};
        IntStream.range(0 , A[0].length()).forEach(
                c -> {
                    char prev = '\0';
                    for(String a : A){
                        char currChar = a.charAt(c);
                        if(prev == '\0' || prev<=currChar) prev = currChar;
                        else {
                            del[0]++;
                            break;

                        }

                    }
                }
        );
        System.out.println("The result is : " + del[0]);
    }
}
