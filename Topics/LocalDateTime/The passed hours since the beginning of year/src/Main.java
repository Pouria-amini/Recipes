import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.next());
        LocalDateTime beginTime = LocalDateTime.parse(dateTime.getYear() + "-01-01T00:00:00");
        System.out.println(beginTime.until(
                dateTime,
                ChronoUnit.HOURS));
    }
}
