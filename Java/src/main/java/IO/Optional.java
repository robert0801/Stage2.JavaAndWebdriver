package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Optional {
    private static String pathFile;

    public static void main(String[] args) {
        pathFile = new File("").getAbsolutePath();
        int placeOfAppearanceInPath = pathFile.lastIndexOf("Java");
        pathFile = pathFile.substring(0, placeOfAppearanceInPath);

        questions1(30);
        questions2(pathFile + "Java/src/main/java/IO/Optional.java",
                pathFile + "Java/src/main/resources/questions2-changePublicToPrivate.java");
        questions3(pathFile + "Java/src/main/java/IO/Optional.java",
                pathFile + "Java/src/main/resources/questions3-reverse.java");
    }

    /*Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.*/
    private static void questions1(int countRandomNumbers) {
        Random random = new Random();
        int[] randomArray = new int[countRandomNumbers];
        for (int i = 0; i < countRandomNumbers; i++) {
            randomArray[i] = random.nextInt();
        }
        Arrays.sort(randomArray);
        try (FileWriter writer = new FileWriter(pathFile + "Java/src/main/resources/questions1.txt")) {
            for (int i = 0; i < randomArray.length; i++) {
                String s = Integer.toString(randomArray[i]);
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.*/
    private static void questions2(String file, String fileOut) {
        String s;
        ArrayList<String> mass;
        String[] massString;
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))) {

            while ((s = reader.readLine()) != null) {
                String line = "";
                mass = new ArrayList<>();
                massString = s.split(" ");

                for (int i = 0; i < massString.length; i++) {
                    if (massString[i].equals("public")) massString[i] = "private";
                    line += (massString[i] + " ");
                }
                mass.add(line);

                for (String line1 : mass) {
                    writer.write(line1 + "\n");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.*/
    private static void questions3(String file, String fileOut) {
        String s;
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))) {

            while ((s = reader.readLine()) != null) {
                for (int i = s.length() - 1; i >= 0; i--)
                    writer.write(s.charAt(i));
                writer.write("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
