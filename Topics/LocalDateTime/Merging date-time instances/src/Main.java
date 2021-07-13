import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {

    public static LocalDateTime merge(LocalDateTime dateTime1,
                                      LocalDateTime dateTime2) {
         return null;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(merge(firstDateTime, secondDateTime));
    }
}