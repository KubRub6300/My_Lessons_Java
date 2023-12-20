package Base.Files.Serialization;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {

        //Запсиь одиночных объектов
        Person person1 = new Person(1,"Danil", "Gardeev");
        Person person2 = new Person(2, "Oleg", "Kucenko");

        try {
            FileOutputStream fos = new FileOutputStream("peoples.bin"); //Класс предназначен для записи байтов в файл
            ObjectOutputStream oos = new ObjectOutputStream(fos);// Класс преднозначен для записи объектов в файлы
            // (преобразует объекты в байты и при помощи fos записывает их в файл)

            oos.writeObject(person1);
            oos.writeObject(person2);

            oos.close();
            System.out.println("Запись прошла успешно!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[ERROR] Неверное имя файла!");;
        }


        //Запись массива объектов 1 способ

        Person[] peoples = {new Person(1, "Maxim", "Serov"), new Person(2, "Tolia", "Kriakov"), new Person(3, "Den", "Lobov")};

        try {
            FileOutputStream fos = new FileOutputStream("peoples2.bin"); //Класс предназначен для записи байтов в файл
            ObjectOutputStream oos = new ObjectOutputStream(fos);// Класс преднозначен для записи объектов в файлы
            // (преобразует объекты в байты и при помощи fos записывает их в файл)

            oos.writeInt(peoples.length);//Записываем длину массива

            for(Person person: peoples){ //Цикл записи каждого элемента массива в файл
                oos.writeObject(person);
            }

            oos.close();
            System.out.println("Запись прошла успешно!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[ERROR] Неверное имя файла!");;
        }


        //Запись массива объектов 2 способ
        try {
            FileOutputStream fos = new FileOutputStream("peoples3.bin"); //Класс предназначен для записи байтов в файл
            ObjectOutputStream oos = new ObjectOutputStream(fos);// Класс преднозначен для записи объектов в файлы
            // (преобразует объекты в байты и при помощи fos записывает их в файл)

            oos.writeObject(peoples);

            oos.close();
            System.out.println("Запись прошла успешно!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[ERROR] Неверное имя файла!");;
        }

    }
}
