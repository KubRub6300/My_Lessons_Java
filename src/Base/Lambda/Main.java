package Base.Lambda;


import java.util.ArrayList;

/**
 * Lambda выражения.
 * Позволяют упростить читабельность кода путём сокращения синтаксиса создания абстрактного класса интерфейса.
 *
 * Функциональный интерфейс.
 * Если интерфейс в Java содержит один и только один абстрактный метод, то он называется функциональным.
 * Этот единственный метод определяет назначение интерфейса.
 *
 * В данном примере будет рассмотрен пример в котором будут выводиться на экран студенты по заданному условию.
 * */
public class Main {

    public static void printStudents(ArrayList<Student> students, CheckStudent cs){
        for (Student s : students){
            if(cs.check(s)){
                System.out.println(s);
            }
        }
    }

    public static void printStudents2(ArrayList<Student> students, CheckStudent2 cs){
        for (Student s : students){
            if(cs.check(s,6)){
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student st1 = new Student("Коля",22,2,45.3);
        Student st2 = new Student("Оля",19,3,56.7);
        Student st3 = new Student("Петя",20,1,83.2);
        Student st4 = new Student("Даша",25,4,25.1);
        Student st5 = new Student("Ваня",34,4,64.4);

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        printStudents(students, new CheckStudent() {
            @Override
            public boolean check(Student s) {
                return s.age>25;
            }
        });//Вот так выглядит абстрактный класс, но его написание можно сократить так как интерфейс функциональный
        System.out.println("==========================");

        printStudents(students, (Student s) -> {return s.age>25;});//Это lambda выражение, значит оно то же самое, что и
        //абстрактный класс сверху
        System.out.println("==========================");


        printStudents(students, s -> {return  s.course<3;});//Можно сократить левую часть
        System.out.println("==========================");

        printStudents(students, s -> s.course<3);//Можно сократить правую часть
        System.out.println("==========================");

        printStudents2(students, (s,a) -> s.course>2 && a>5);//Если метода принимает две переменный, то их нужно
        // Обязательно указывать в скобках, тип переменных можно не указывать.
        // В данном примере переменная 'a' бесполезна просто создана для примера.
        System.out.println("==========================");

        final int i = 10;
        printStudents(students, s -> s.age%i == 0);//В lambda выражении можно использовать переменную из вне,
        // Но при этом её нельзя изменять не до ни после lambda выражения. Так что лучше сделать её final
        // P.S. Здесь проверяется, что у студента круглый возраст (делится на 10 без остатка)








    }
}

interface CheckStudent{//Функциональный интерфейс (имеет только 1 абстрактный класс)
    public boolean check(Student s);
}

interface CheckStudent2{//Функциональный интерфейс (имеет только 1 абстрактный класс)
    public boolean check(Student s,int a);
}

