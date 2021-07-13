import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime time = LocalTime.parse(scanner.nextLine());
        time = time.minusHours(scanner.nextInt());
        time = time.minusMinutes(scanner.nextInt());
        System.out.println(time);
    }
}