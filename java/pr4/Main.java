import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // задание 1
        // создать массив содержащий 10 первых нечетных чисел, выведите элементы в консоль разделяя запятой
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2 + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

        // задание 2
        // Дан массив размерности N, найти наименьший элемент массива и вывести на консоль (если наименьших элементов несколько — вывести их все).
        int[] arr2 = new int[10];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr2));
        int min = arr2[0];
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < min) {
                min = arr2[i];
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == min) {
                System.out.println(arr2[i]);
            }
        }

        // задание 3
        int max = arr2[0];
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr2[i];
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == max) {
                System.out.println(arr2[i]);
            }
        }

        // задание 4
        // Поменять наибольший и наименьший элементы массива местами. Пример: дан
        // массив {4, -5, 0, 6, 8}. После замены будет выглядеть {4, 8, 0, 6, -5}.
        int[] arr3 = new int[10];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr3));
        int max2 = arr3[0];
        int min2 = arr3[0];
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] > max2) {
                max2 = arr3[i];
            }
            if (arr3[i] < min2) {
                min2 = arr3[i];
            }
        }
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] == max2) {
                arr3[i] = min2;
            }
            if (arr3[i] == min2) {
                arr3[i] = max2;
            }
        }

        // задание 5
        // Найти среднее арифметическое всех элементов массива.
        int[] arr4 = new int[10];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr4));
        int sum = 0;
        for (int i = 0; i < arr4.length; i++) {
            sum += arr4[i];
        }
        System.out.println(sum / arr4.length);

    }
}
