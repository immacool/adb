
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // задание 1
        // Создайте массив из 20 случайных чисел (числа должны быть в диапазоне от 0 до 1000)
        // и отсортируйте массив по убыванию при помощи сортировки пузырьком.
        int[] arr = new int[20];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(1000);
        }
        System.out.println("Исходный массив");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Отсортированный массив");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // задание 2
        // Создайте массив содержащий марки автомобилей, отсортируйте его сначала по возрастанию, потом по убыванию.
        String[] cars = {"BMW", "Audi", "Mercedes", "Toyota", "Volkswagen", "Ford", "Nissan"};
        System.out.println("Исходный массив");
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i] + " ");
        }
        System.out.println();
        Arrays.sort(cars);
        System.out.println("Отсортированный массив по возрастанию");
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i] + " ");
        }
        System.out.println();
        Arrays.sort(cars, Collections.reverseOrder());
        System.out.println("Отсортированный массив по убыванию");
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i] + " ");
        }
    }
}
