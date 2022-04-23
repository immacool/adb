import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // задание 1
        // Создайте массив размерностью 5 на 6 и заполните его случайными числами (в диапазоне от 0 до 99 ).
        // Выведите на консоль третью строку
        Random rnd = new Random();
        int[][] arr = new int[5][6];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rnd.nextInt(100);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[2][i] + " ");
            System.out.println();
        }

        // задание 2
        // Даны матрицы С и D размерностью 3 на 3 и заполненные случайными числами в диапазоне от 0 до 99 
        // Выполните по отдельности сначала сложение, потом умножения матриц друг на друга.
        // Выведете исходные матрицы и результат вычислений на консоль.
        int[][] C = new int[3][3];
        int[][] D = new int[3][3];
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                C[i][j] = rnd.nextInt(100);
                D[i][j] = rnd.nextInt(100);
            }
        }
        System.out.println("Матрица C");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Матрица D");
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D[i].length; j++) {
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
        int[][] sum = new int[3][3];
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                sum[i][j] = C[i][j] + D[i][j];
            }
        }
        System.out.println("Сумма матриц C и D");
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        int[][] mult = new int[3][3];
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                mult[i][j] = C[i][j] * D[i][j];
            }
        }
        System.out.println("Произведение матриц C и D");
        for (int i = 0; i < mult.length; i++) {
            for (int j = 0; j < mult[i].length; j++) {
                System.out.print(mult[i][j] + " ");
            }
            System.out.println();
        }

        // задание 3
        // Просуммируйте все элементы двумерного массива.
        // Выведите на консоль результат.
        int[][] arr3 = new int[5][6];
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                arr3[i][j] = rnd.nextInt(100);
            }
        }
        int sum3 = 0;
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                sum3 += arr3[i][j];
            }
        }
        System.out.println("Сумма всех элементов массива: " + sum3);

        // задание 4
        // Дан двумерный массив содержащий отрицательные и положительные числа.
        // Выведете на экран номера тех ячеек массива, которые содержат отрицательные числа.
        int[][] arr4 = new int[5][5];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                arr4[i][j] = rnd.nextInt(100) - 50;
            }
        }
        System.out.println("Массив с отрицательными числами");
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Ячейки с отрицательными числами");
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (arr4[i][j] < 0) {
                    System.out.print(i + " " + j + " ");
                }
            }
        }

        // задание 5
        // Отсортируйте элементы в строках двумерного массива по возрастанию
        int[][] arr5 = new int[5][5];
        for (int i = 0; i < arr5.length; i++) {
            for (int j = 0; j < arr5[i].length; j++) {
                arr5[i][j] = rnd.nextInt(100);
            }
        }
        System.out.println("Массив до сортировки");
        for (int i = 0; i < arr5.length; i++) {
            for (int j = 0; j < arr5[i].length; j++) {
                System.out.print(arr5[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr5.length; i++) {
            Arrays.sort(arr5[i]);
        }
        System.out.println("Массив после сортировки");
        for (int i = 0; i < arr5.length; i++) {
            for (int j = 0; j < arr5[i].length; j++) {
                System.out.print(arr5[i][j] + " ");
            }
            System.out.println();
        }
    }
}
