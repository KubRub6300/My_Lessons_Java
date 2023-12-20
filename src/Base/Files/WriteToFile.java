package Base.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile { //Класс для записи в файл
    // Сериализация - запись объекта в файлы
    String path;

    public WriteToFile(String path){
        this.path = path;
    }

    public void writeText() throws FileNotFoundException {
        File file = new File(path);
        PrintWriter pw = new PrintWriter(file); //Перезапишет текст в файле

        pw.println("Тестовая строка 1");
        pw.println("Тестовая строка 2");

        pw.close();
    }
}
