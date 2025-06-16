import sweets.Candy;
import sweets.Chocolate;
import sweets.Jellybean;
import sweets.Sweetness;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Part 1");
        Random random = new Random();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(200) - 100;
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int minIndex = findMinPositiveInArray(array);
        int maxIndex = findMaxNegativeInArray(array);
        System.out.println("Index min+ " + minIndex);
        System.out.println("Index max- " + maxIndex);
        swapElements(maxIndex, minIndex, array);
        System.out.println("Array after changing:");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println("\n\nPart 2");
        Candy candyStrawberry = new Candy("Strawberry", 10.4, 5.5, "XXL");
        Candy candyBlueberry = new Candy("Blueberry", 5.2, 3.5, "XL");
        Jellybean jellybeanApple = new Jellybean();
        jellybeanApple.setName("Apple");
        jellybeanApple.setWeight(5.0);
        jellybeanApple.setPrice(2.5);
        jellybeanApple.setElasticity("Very");
        Chocolate chocolateWhite = new Chocolate("White", 45.0, 20.3, "white");
        Sweetness[] gifts = {candyStrawberry, candyBlueberry, chocolateWhite, jellybeanApple};
        Double commonWeight = 0.0;
        Double commonPrice = 0.0;
        for (Sweetness sweet : gifts) {
            commonWeight += sweet.getWeight();
            commonPrice += sweet.getPrice();
            System.out.println(sweet.toString());
        }
        System.out.println("Common weight = " + commonWeight);
        System.out.println("Common price = " + commonPrice);
    }

    /**
     * Метод меняет местами 2 элемента массива
     *
     * @param firstIndex  индекс первого для замены элемента
     * @param secondIndex индекс второго для замены элемента
     * @param array       массив, в котором нужно поменять местами элементы
     */
    private static void swapElements(int firstIndex, int secondIndex, int[] array) {
        int elementForChange = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = elementForChange;
    }

    /**
     * Метод для поиска минимального положительного элемента в массиве
     *
     * @param array массив, в котором ищем
     * @return индекс минимального положительного элемента
     */
    private static int findMinPositiveInArray(int[] array) {
        int min = 500, minIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (array[i] < min) {
                    min = array[i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    /**
     * Метод для поиска максимального отрицательного элемента в массиве
     *
     * @param array массив, в котором ищем
     * @return индекс максимального отрицательного элемента
     */
    private static int findMaxNegativeInArray(int[] array) {
        int max = -500, maxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                if (array[i] > max) {
                    max = array[i];
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }
}