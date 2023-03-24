import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Монько Максим Витальевич");
        System.out.println("РИБО-01-21");

        String path;
        File file;
        while (true) {
            System.out.println();
            System.out.println("Введите путь к файлу:");
            path = scan();
            if (path.isEmpty() || path.isBlank()) {
                System.out.println("Путь необходимо заполнить!");
                continue;
            }
            file = new File(path);
            if (!file.exists()) {
                System.out.println("Файл не найден! Попробуйте снова.");
                continue;
            }
            if (file.isDirectory()) {
                System.out.println("Ошибка! Необходимо указать файл, а не директорию.");
                continue;
            }
            break;
        }

        File newFile = new File(file.getParent() + "\\result.txt");
        try {
            Scanner scanner = new Scanner(file);
            String line;
            FileWriter writer = new FileWriter(newFile);
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                writer.write((new StringBuilder(line).reverse()) + "\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Готово!");
        System.out.println("Путь к результату: " + newFile.getAbsolutePath());
    }

    public static String scan() {
        return new Scanner(System.in).nextLine();
    }
}