public class Unicode {

    public static void main(String[] args) {
        char symbol = ' ';
        // символы ASCII
        System.out.println("Символы от 33 до 126");
        for (int i = 33; i <= 126; i++) {
            symbol = (char)i;
            System.out.println(i + "\t" + symbol);
            //System.out.print(charAt(i) + " ");
        }
        // символы Unicode
        System.out.println("Символы Unicode от 9398 до 10178");
        for (int i = 9398; i <=10178; i++) {
            symbol = (char)i;
            System.out.println(i + "\t" + symbol);
        }
    }
}