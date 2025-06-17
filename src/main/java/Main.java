import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder strings = new StringBuilder();
    private static ArrayList<String> unsortedWords;
    private static TreeMap<String, Integer> repeatCountFruits = new TreeMap<>();

    public static void main(String[] args) {
        readFile();
        unsortedWords = new ArrayList<>(Arrays.asList(strings.toString().split(" ")));
        System.out.println("List from file:");
        System.out.println(unsortedWords);
        System.out.println("\nSorted list:");
        Collections.sort(unsortedWords);
        System.out.println(unsortedWords);
        countRepeatInList();
        System.out.println("\nFruit=repeat count:");
        System.out.println(repeatCountFruits);
        String maxRepeatFruit = findMaxRepeatFruit(repeatCountFruits);
        System.out.println("\nMAX repeat fruit: " + maxRepeatFruit + " = " + repeatCountFruits.get(maxRepeatFruit));
    }

    /**
     * Метод чтения слов из файла в одну строку
     */
    private static void readFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/files/Strings.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings.append(line);
                strings.append(" ");
            }
        } catch (IOException ignored) {
        }
    }

    /**
     * Метод подсчёта количества повторений слов в строке
     */
    private static void countRepeatInList() {
        for (String fruit : unsortedWords) {
            int fruitCount = repeatCountFruits.get(fruit) != null ? repeatCountFruits.get(fruit) : 0;
            fruitCount++;
            repeatCountFruits.put(fruit, fruitCount);
        }
    }

    /**
     * Метод поиска слова с максимальным количеством повторений.
     *
     * @param treeMap - отсортированный по алфавиту список слов с количеством посторий каждого
     * @return слово, имеющее максимальное число повторений
     */
    private static String findMaxRepeatFruit(TreeMap<String, Integer> treeMap) {
        String maxRepeatFruit = "";
        int maxRepeat = 0;
        for (Map.Entry<String, Integer> fruit : treeMap.entrySet()) {
            if (fruit.getValue() > maxRepeat) {
                maxRepeatFruit = fruit.getKey();
                maxRepeat = fruit.getValue();

            }
        }
        return maxRepeatFruit;
    }
}