import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStores = scanner.nextInt();
        while (--numberOfStores >= 0) {
            String store = scanner.next();
            LocalTime time = LocalTime.parse(scanner.next());
            if (time.compareTo(LocalTime.of(20, 0)) > 0) {
                System.out.println(store);
            }
        }
    }
}