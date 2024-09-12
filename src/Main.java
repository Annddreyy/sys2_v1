import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Размер массива
        final int ArraySize = 1000;

        // Массив чисел
        int[] numbers = new int[ArraySize];

        // Добавление чисел из файла в массив
        try {
            File file = new File("IN.txt");
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < ArraySize; i++) {
                int number = Integer.parseInt(scanner.nextLine());
                numbers[i] = number;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }

        // Максимальное число, кратное 2, но не кратное 14
        int max2 = 0;
        // Максимальное число, кратное 7, но не кратное 14
        int max7 = 0;
        // Максимальное число, кратное 14
        int max14 = 0;
        // Максимальное число, не кратное 2, 7 и 14
        int max = 0;

        // Поиск максималльных чисел
        for (int i = 0; i < ArraySize; i++) {
            if (numbers[i] % 14 == 0 && numbers[i] > max14) max14 = numbers[i];
            else if (numbers[i] % 2 == 0 && numbers[i] > max2) max2 = numbers[i];
            else if (numbers[i] % 7 == 0 && numbers[i] > max7) max7 = numbers[i];
            else if (numbers[i] > max) max = numbers[i];
        }

        int result1 = 0;
        int result2 = 0;

        // Находим два возможных ответа - максимальное число, кратное 2 * макисмальное число, кратное 7
        if (max2 != 0 && max7 != 0) result1 = max2 * max7;
        // Максимальное число, кратное 14 * максимальное число, не кратное 14
        if (max14 != 0) result2 = max14 * Math.max(max2, Math.max(max7, max));

        int answer = Math.max(result1, result2);

        if (answer != 0) System.out.println(answer);
        else System.out.println(-1);
    }
}