package Base.Files.Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {

        //Считывание одиночных объектов
        try {
            FileInputStream fis = new FileInputStream("peoples.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person person1 = (Person) ois.readObject();
            Person person2 = (Person) ois.readObject();

            System.out.println(person1);
            System.out.println(person2);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Считывание массива объектов (для первого способа записи)
        try {
            FileInputStream fis = new FileInputStream("peoples2.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            int len = ois.readInt();//Считываем длинну массива

            Person[] peoples = new  Person[len];
            for (int i = 0; i < len; i++){
                peoples[i] = (Person) ois.readObject();
            }

            System.out.println(Arrays.toString(peoples));
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Считывание массива объектов (для второго способа записи)
        try {
            FileInputStream fis = new FileInputStream("peoples3.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);


            Person[] peoples = (Person[]) ois.readObject();

            System.out.println(Arrays.toString(peoples));
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
