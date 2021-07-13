import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
        dateTime = dateTime.plusMinutes(scanner.nextInt());
        System.out.println(dateTime.getYear() +
                " " + dateTime.getDayOfYear() +
                " " + dateTime.toLocalTime());
    }
}