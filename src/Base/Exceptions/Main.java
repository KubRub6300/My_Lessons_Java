package Base.Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        readFile1();

        try {
            readFile2();
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] main()");
            System.out.println("Файл не найден");
            e.printStackTrace();
        }

        try {
            throw new MyException("Описание проблемы");
        }
        catch (MyException e){
            e.printStackTrace();
        }

        while (true) {
            System.out.println("Введите y: ");
            try {
                int y = sc.nextInt();
                switch (y){
                    case 0:
                        throw new IOException();
                    case 1:
                        throw new MyException("Моё исключение");

                }
            } catch (IOException | MyException e){ //одна обработка для нескольких типов исключений
                System.out.println("Сработало исключение!");
            }
            catch (Exception e) { //Если не какое-то из исключений в первом cath
                System.out.println("x должно быть числом");
            }

            while (true){
                int x;
                try {
                    x = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Введено не число!");
                    break;
                }

                if (x!=0){
                    try {
                        throw new IOException(); // выбрасываем исключение
                    } catch (IOException e) {
                        System.out.println("Введён не 0");
                        break;
                    }
                }
            }
            
        }



    }

    public static void readFile1(){
        System.out.println("readFile1");
        File file = new File("No file");

        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] readFile1()");
            System.out.println("Файл не найден");
            e.printStackTrace();
        }
    }

    public static void readFile2() throws FileNotFoundException {// throws FileNotFoundException говорит о том,
        // что ошибки связанные с не найденным файлом должны быть обработаны там откуда вызывается метод
        System.out.println("readFile2");
        File file = new File("No file");
        Scanner scanner = new Scanner(file);

    }
}
