import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] yearAndDay = scanner.nextLine().split(" ");
        LocalDate date = LocalDate.ofYearDay(
                Integer.parseInt(yearAndDay[0]),
                Integer.parseInt(yearAndDay[1]));
        System.out.println(date.getDayOfMonth()==1);
    }
}