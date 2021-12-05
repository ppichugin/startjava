import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Unicode {

    public static void main(String[] args) {

        System.out.println("Символы от 33 до 126");
        for (char i = 33; i <= 126; i++) {
            System.out.print(i);
        }
        System.out.println(" " + "\n");
        System.out.println("Символы Unicode от 9398 до 10178");
        try {
            PrintStream outStream = new PrintStream(System.out, true, "UTF-8");
            for (char c = 9398; c <= 10178; c++) {
                outStream.print(c);
            }
        } catch(UnsupportedEncodingException e){
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}