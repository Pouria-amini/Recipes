import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

class Main {

    public static Consumer<List<String>> func = x -> x.forEach(y -> System.out.print(y + " "));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String > list = Arrays.asList(scanner.nextLine().split(" "));
        int noOfSwaps = scanner.nextInt();
        while (--noOfSwaps >= 0) {
            Collections.swap(list, scanner.nextInt(), scanner.nextInt());
        }
        func.accept(list);
    }
}