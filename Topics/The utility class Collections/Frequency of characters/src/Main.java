import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] chars = scanner.nextLine().split(" ");
        String required = scanner.next();
        System.out.println(Collections.frequency(Arrays.asList(chars), required));
    }
}