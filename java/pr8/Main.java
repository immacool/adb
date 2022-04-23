
public class Main {
    public static void main(String[] args) {
        // В программе, вычисляющей сумму элементов типа byte одномерного массива,
        // вводимого с клавиатуры, могут возникать ошибки в следующих случаях:
        // – ввод строки вместо числа;
        // – ввод или вычисление значения за границами диапазона типа.     
        sumWithCatches();
        sum();
    }

    public static int sumWithCatches() {
        byte[] arr = new byte[10];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            try {
                arr[i] = Byte.parseByte(System.console().readLine());
                sum += arr[i];
            } catch (NumberFormatException e) {
                System.out.println("Введено не число");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Введено значение за границами диапазона");
            }
        }
        System.out.println("Сумма элементов массива: " + sum);
    }

    public static int sum() {
        byte[] arr = new byte[10];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Byte.parseByte(System.console().readLine());
            sum += arr[i];
        }
        System.out.println("Сумма элементов массива: " + sum);
        return sum;
    }
}