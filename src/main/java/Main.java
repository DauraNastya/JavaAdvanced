import java.util.Random;

public class Main {
    public static void main(String[] args) {
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