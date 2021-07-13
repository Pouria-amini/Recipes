import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        String[] seqs = scanner.nextLine().split(" ");
        System.out.print(Collections.indexOfSubList(
                Arrays.asList(nums),
                Arrays.asList(seqs)) + " ");
        System.out.print(Collections.lastIndexOfSubList(
                Arrays.asList(nums),
                Arrays.asList(seqs)));
    }
}