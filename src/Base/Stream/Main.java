package Base.Stream;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream – это последовательность элементов, поддерживающих последовательные и параллельные операции над ними.
 *
 * При его использовании, также используются lambda выражения.
 * @see Base.Lambda.Main
 * */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Привет");
        list.add("Как дела?");
        list.add("Хорошо!");
        list.add("Ты как?");

        // Преобразуем list в stream с помощью метода .stream(), потом с помощью метода map и lambda выражения внутри
        // изменяем значения элементов стрима.
        // После при помощи метода .collect() преобразуем обратно в лист и записываем результат в лист list2,
        // при этом list не изменяется.
        System.out.println("Вывод длин слов вместо слов");
        List<Integer> list2 =  list.stream().map( el -> el.length()).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list2);


        System.out.println("\nДеление всех элементов массив, которые делятся на 3, на 3");
        int[] array = {5,9,8,3,4,1};
        System.out.println(Arrays.toString(array));
        array = Arrays.stream(array).map(el ->
        {
            if (el % 3 == 0){
               el = el/3;
            }
            return el;
        }).toArray();

        System.out.println(Arrays.toString(array));



        List<Base.Stream.Student> students = new ArrayList<>();
        Base.Stream.Student st1 = new Base.Stream.Student("Коля",22,2,45.3);
        Base.Stream.Student st2 = new Base.Stream.Student("Оля",19,3,56.7);
        Base.Stream.Student st3 = new Base.Stream.Student("Петя",20,1,83.2);
        Base.Stream.Student st4 = new Base.Stream.Student("Даша",25,4,25.1);
        Base.Stream.Student st5 = new Base.Stream.Student("Ваня",34,4,64.4);

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);


        System.out.println("\nМетод filter:");
        students = students.stream().filter(e -> e.age>20 && e.course<5).collect(Collectors.toList());
        System.out.println(students);

        System.out.println("\nМетод foreach: ");
        Stream<Base.Stream.Student> stream = Stream.of(st1,st2,st3,st4,st5);//Создание стрима из элементов
        stream.forEach(el-> System.out.println(el));


        System.out.println("\nРеференс метод: ");
        //Вместо лямбда выражения можно писать референс метод, в который java сама будет передавать каждый элемент стрима
        students.stream().forEach(PrintSt::print);

        System.out.println("Проведение мат операций с элементами коллекции");
        int sum = Arrays.stream(array).reduce(0,(accumulator,el) -> accumulator+el);
        System.out.println(Arrays.toString(array));
        System.out.println(sum);


        //Метод sorted

        int[] array2 = {3,6,1,65,3,7,2,86,24,0,13};
        System.out.println("\n\nНесортированный массив: " +Arrays.toString(array2));
        array2 = Arrays.stream(array2).sorted().toArray();
        System.out.println("Отсортированный массив: " +Arrays.toString(array2));


        System.out.println("\nСтуденты неотсортированные:\n" +students);
        // сортировка листа студентов в обратном порядке по возрасту
        students =  students.stream().sorted((o1,o2) -> {
            return o2.age - o1.age;
        }).collect(Collectors.toList());
        System.out.println("Студенты отсортированные в обратном порядке по возрасту:\n" +students);

        students = students.stream().sorted().collect(Collectors.toList());
        System.out.println("Студенты отсортированные по курсу:\n" +students);



        // Метод concat объединяет несколько стримов в один. Является статическим методом

        Stream<Integer> stream1 = Stream.of(1,2,3);
        Stream<Integer> stream2 = Stream.of(3,2,1);
        Stream<Integer> stream3 = Stream.of(0,0,0);
        Stream<Integer> stream4 = Stream.concat(stream1,stream3);
        stream4 = Stream.concat(stream4,stream2);
        System.out.println("\nStream 4");
        stream4.forEach(System.out::print);
        Stream<Integer> stream5 = Stream.of(1,2,3,4,5,1,2,3);

        //Метод distinct возвращает уникальные элементы (сравнивает через equal)
        System.out.println("\nStream 5");
        stream5.distinct().forEach(System.out::print);

        // Метод count выводит кол-во элементов в потоке

        System.out.println("\nКоличество элементов в листе students: " + students.stream().count());


        // Метод peek то же, что и foreach, только возвращает поток
        System.out.println("\n");
        // почему-то не работает -_-
        System.out.println("\nЭлементы листа students и их количество: " + students.stream().peek(System.out::println).count());

        // Метод flatMap позволяет работать с потоком(stream) для вложенных объектов

        Faculty faculty1 = new Faculty("fit");
        Faculty faculty2 = new Faculty("feat");

        List<Faculty> faculties = new ArrayList<>();
        faculty1.add_student(st1);
        faculty1.add_student(st2);
        faculty1.add_student(st3);
        faculty2.add_student(st4);
        faculty2.add_student(st5);
        faculties.add(faculty1);
        faculties.add(faculty2);

        faculties.stream().flatMap(faculty -> faculty.get_students().stream()).forEach(System.out::println);

        // Метод collect: grouping и partition

        Map<Integer,List<Base.Stream.Student>> map_students = students.stream().map(st ->{
            st.course+=1;
            return st;
        }).collect(Collectors.groupingBy(student -> student.get_course()));

        System.out.println("\nГруппировка студентов по курсу: ");
        for(Map.Entry<Integer,List<Base.Stream.Student>> entry : map_students.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nРазделение студентов по возрасту: ");
        Map<Boolean, List<Base.Stream.Student>> map_students2 =  students.stream().collect(Collectors.partitioningBy(st -> st.age>22));

        for(Map.Entry<Boolean,List<Base.Stream.Student>> entry : map_students2.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        // Метод findFirst выводит первый элемент
        // Этот метод возвращает объект класса Optional (некий класс обёртка для обработки возможных null - значений)
        // Метод orElseGet вернёт или элемент в Optional или значение по умолчанию (то, что указано внутри него)
        // Подробнее почитать можно здесь https://habr.com/ru/articles/658457/

        Student student_first = students.stream().filter(el->el.age<30).findFirst().
                orElseGet(()->new Student(null,0,0,0));
        System.out.println("\nПервый студент в листе с возрастом меньше 30:");
        System.out.println(student_first);

        //Метод min

        Student student_min = students.stream().min(((o1, o2) -> o1.age - o2.age)).orElse(new Student(null,0,0,0));
        System.out.println("\nСамый младший студент: " + student_min);

        //Метод max

        Student student_max = students.stream().max(((o1, o2) -> o1.age - o2.age)).orElse(new Student(null,0,0,0));
        System.out.println("\nСамый старший студент: " + student_max);

        //Метод limit

        students.clear();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        System.out.println("\nВсе студенты:");
        students.stream().forEach(System.out::println);

        System.out.println("\nПервые 3 студента которым больше 19 лет");
        students.stream().filter(st->st.age>19).limit(3).forEach(System.out::println);

        //Метод skip

        System.out.println("\nСтуденты которым больше 19 пропуская первых двух");
        students.stream().filter(st->st.age>19).skip(2).forEach(System.out::println);

        // Метод mapToInt
        // Метод boxed преобразует int в Integer

        List<Integer> courses = students.stream().mapToInt(el->el.get_course()).boxed().collect(Collectors.toList());
        System.out.println(courses);

        //ParallelStream разделяем стрим на несколько потоков, но нужно быть осторожней,
        // так как например деление всех элементов таким образом приведёт к ошибке.
        // Если элементов не много, то выгоднее будет использовать обычный Stream

        List<Double> d_list = new ArrayList<>();
        d_list.add(4.2);
        d_list.add(1.3);
        d_list.add(5.0);
        d_list.add(7.4);

        double d_sum = d_list.stream().reduce((ac,el) -> ac+=el).orElse(0.0);
        System.out.println("Сумма при обычно Stream: " + d_sum);

        d_sum = d_list.parallelStream().reduce((ac,el) -> ac+=el).orElse(0.0);
        System.out.println("Сумма при параллельном Stream: " + d_sum);

        double division = d_list.stream().reduce((ac,el) -> ac/=el).orElse(0.0);
        System.out.println("Деление при обычно Stream: " + String.valueOf(division).substring(0,7));

        division = d_list.parallelStream().reduce((ac,el) -> ac/=el).orElse(0.0);
        System.out.println("Деление при параллельном Stream: " + String.valueOf(division).substring(0,7));

    }
}

class sortStAge implements Comparator<Base.Stream.Student> {

    @Override
    public int compare(Base.Stream.Student o1, Base.Stream.Student o2) {
        return o1.age-o2.age;
    }
}

class PrintSt{

    public static void print(Base.Stream.Student student){
        System.out.println("================= Студент =================");
        System.out.println(student);
    }
}
