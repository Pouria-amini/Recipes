import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.of(year, month, 1);
        System.out.print(date);
        System.out.println(" " + date.plusDays(date.lengthOfMonth()-1));
    }
}