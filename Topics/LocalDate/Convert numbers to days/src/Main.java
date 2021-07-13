import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < 3; i++) {
            System.out.println(LocalDate.ofYearDay(year, Integer.parseInt(scanner.nextLine())));
        }
    }
}