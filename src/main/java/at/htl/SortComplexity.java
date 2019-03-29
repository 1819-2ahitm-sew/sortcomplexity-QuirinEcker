package at.htl;

import java.util.Random;
import java.util.Scanner;

public class SortComplexity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Anzahl der zu sortierenden Arrays: ");
        int anzahlOfArrays = scanner.nextInt();

        System.out.print("Größe der Arrays: ");
        int arraySize = scanner.nextInt();

        System.out.println();

        int[] allSortingTimes = new int[anzahlOfArrays];
        for (int i = 0; i < anzahlOfArrays; i++) {
            allSortingTimes[i] = (int)sortRandomArray(arraySize);
            System.out.println("Laufzeit zur Sortierung des " + i + ". Arrays: " + allSortingTimes[i] + "ms");
        }

        System.out.println();
        System.out.println("Durchschnittliche Laufzeit: " + averageSortingTime(allSortingTimes) + "ms");
    }

    private static int averageSortingTime(int[] allSortingTimes) {
        int sum = 0;
        int average;

        for (int i = 0; i < allSortingTimes.length; i++)
            sum += allSortingTimes[i];

        average = sum / allSortingTimes.length;

        return average;
    }

    private static void showArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]);
    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {
        int numbers[] = generateRandomArray(length);
        int timeBeforeSort = (int)System.currentTimeMillis();
        sort(numbers);
        int timeAfterSort = (int)System.currentTimeMillis();

        return timeAfterSort - timeBeforeSort;
    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++)
            numbers[i] = random.nextInt(100);

        return numbers;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {
        int i = array.length - 1;
        boolean swaped = false;

        do {
            swaped = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    swaped = true;
                }
            }
            i--;
        } while (swaped || (i >= 0));
    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {
        int help = array[i];
        array[i] = array[j];
        array[j] = help;
    }
}
