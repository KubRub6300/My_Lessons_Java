package Base.Reflection;


import java.lang.reflect.*;
import java.util.Arrays;

/**
 * <h1>Рефлексия</h1>
 * Рефлексия – это механизм исследования данных о программе во время её выполнения.<br>
 * Рефлексия позволяет исследовать информацию о полях, методах, конструкторах и других составляющих классов.<br>
 * <br>
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class employeeClass1 = Class.forName("Base.Reflection.Employee");
        Class employeeClass2 = Employee.class;
        Employee employee = new Employee();
        Class employeeClass3 = employee.getClass();

        Field filedId = employeeClass1.getField("id");
        System.out.println("Тип поля " + filedId.getName() + " - " + filedId.getType());
        System.out.println("----------------------------------\n");


        Field[] employeeFields = employeeClass1.getFields();// Все поля с уровнем доступа public, protected, default
        Field[] allEmployeeFields = employeeClass1.getDeclaredFields();// Все поля, любого уровня доступа

        System.out.println("----------------------------------");
        for (Field field : allEmployeeFields) {
            System.out.println("У поля " + field.getName() + " тип " + field.getType());
        }
        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        Method method1 = employeeClass1.getMethod("getSalary");//Если метод не принимает параметры, то просто название метода
        System.out.println("Название метода: " + method1.getName());
        System.out.println("Принимаемые параметры: " + Arrays.toString(method1.getParameters()));
        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        Method method2 = employeeClass1.getMethod("setSalary", double.class);//Если есть параметры, то указываются их классы через запятую
        System.out.println("Название метода: " + method2.getName());
        System.out.println("Принимаемые параметры: " + Arrays.toString(method2.getParameters()));
        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        Method[] methods = employeeClass1.getMethods();//Получение всех не private методов, в том числе методов родителей
        for (Method method : methods) {
            System.out.println("Название метода: " + method.getName());
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Принимаемые параметры: " + Arrays.toString(method.getParameters()) + "\n-");
        }
        System.out.println("Количество методов: " + methods.length);
        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        Method[] allMethods = employeeClass1.getDeclaredMethods();//Получение всех методов класса (private тоже) и переопределённых родительских методов
        for (Method method : allMethods) {
            System.out.println("Название метода: " + method.getName());
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Принимаемые параметры: " + Arrays.toString(method.getParameters()) + "\n-");
        }
        System.out.println("Количество методов: " + allMethods.length);
        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        for (Method method : allMethods) {
            if (!Modifier.isPublic(method.getModifiers())) continue; // Проверка на то, что метод public
            System.out.println("Название метода: " + method.getName());
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Принимаемые параметры: " + Arrays.toString(method.getParameters()) + "\n-");
        }
        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        Constructor emptyConstructor = employeeClass1.getConstructor();
        System.out.println("Название конструктора: " + emptyConstructor.getName());
        System.out.println("Принимаемые параметры: " + Arrays.toString(emptyConstructor.getParameters()));
        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        Constructor constructor1 = employeeClass1.getConstructor(int.class, String.class, String.class);
        System.out.println("Название конструктора: " + constructor1.getName());
        System.out.println("Принимаемые параметры: " + Arrays.toString(constructor1.getParameters()));
        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        Constructor[] constructors = employeeClass1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Название конструктора: " + constructor.getName());
            System.out.println("Принимаемые параметры: " + Arrays.toString(constructor.getParameters()) + "\n-");
        }
        System.out.println("Количество конструкторов: " + constructors.length);
        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        Constructor[] constructors2 = employeeClass1.getDeclaredConstructors();
        for (Constructor constructor : constructors2) {
            System.out.println("Название конструктора: " + constructor.getName());
            System.out.println("Принимаемые параметры: " + Arrays.toString(constructor.getParameters()) + "\n-");
        }
        System.out.println("Количество конструкторов: " + constructors2.length);
        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        Constructor<Employee> constructor3 = employeeClass1.getConstructor();
        Employee employee1 = constructor3.newInstance();

        Constructor constructor4 = employeeClass1.getConstructor(int.class, String.class, String.class);
        Object object = constructor4.newInstance(1, "Petr", "Fedorov");
        System.out.println(object);

        Method method3 = employeeClass1.getMethod("setSalary", double.class);
        method3.invoke(object, 20000.0);

        System.out.println(object);

        System.out.println("----------------------------------\n");


        System.out.println("----------------------------------");
        Employee employee2 = new Employee(2, "Vitaliy", "Purov");
        Class employeeClass4 = employee2.getClass();

        Field field = employeeClass4.getDeclaredField("department");
        field.setAccessible(true);//Выдача себе доступа к private полям

        String departmentValue = (String) field.get(employee2);
        System.out.println(departmentValue);

        field.set(employee2, "HR");
        departmentValue = (String) field.get(employee2);
        System.out.println(departmentValue);
        System.out.println(employee2);

        System.out.println("----------------------------------\n");





    }
}
