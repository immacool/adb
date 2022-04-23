import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // задание 1
        System.out.println(Arrays.stream(new int[] {8, 34, 1, 42}).min().getAsInt());

        // задание 2
        int[] arr = {8, 34, 1, 42};
        int max = Arrays.stream(arr).max().getAsInt();
        int count = 1;

        for (int i : arr)
            if (i == max)
                count += 1;

        System.out.println(count);

        // задание 3
        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.stream(arr2).max().getAsInt());
        System.out.println(Arrays.stream(arr2).min().getAsInt());

        // задание 4
        Scanner scanner = new Scanner(System.in);

        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();

        System.out.println(Objects.equals(name1, name2) ? "Тезки" : "Имена разные!");

        // задание 5
        int mounth = scanner.nextInt();
        
        switch (mounth) {
            case 1:
            case 2:
            case 12:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
        
        }
    }
}
