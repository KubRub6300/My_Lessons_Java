package Base.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String sep = File.separator; //Джава определяет разделитель между папками в пути для ОС на которой она запущена

        String path = "C:"+sep+"Users"+sep+"danil"+sep+"IdeaProjects"+sep+"My_Lessons_Java"+sep+"src"+sep+"Base"+sep+"Files"+sep+"text.txt";


        WriteToFile write = new WriteToFile(path);
        write.writeText();

        File file = new File(path);


        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }

        while (scanner.hasNext())
            System.out.println(scanner.next());

        scanner.close();// Нужно закрывать сканер!
    }
}
