package Base.Reflection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

public class Calculator {

    @MathOperation(name = "sum", description = "сумма двух чисел")
    public void sum(int a, int b) {
        int result = a + b;
        System.out.println(result);
    }

    @MathOperation(name = "sub", description = "вычитание двух чисел")
    public void sub(int a, int b) {
        int result = a - b;
        System.out.println(result);
    }

    @MathOperation(name = "dev", description = "деление двух чисел")
    public void dev(int a, int b) {
        int result = a / b;
        System.out.println(result);
    }

    @MathOperation(name = "mult", description = "умножение двух чисел")
    public void mult(int a, int b) {
        int result = a * b;
        System.out.println(result);
    }

    @MathOperation(name = "secret", description = "секретное действие")
    public void myop(int a, int b) {
        int result = a * b - a + b / a * b;
        System.out.println(result);
    }


    @MathOperation(name = "plus100", description = "Плюсует 100")
    public void dsds(int a, int b) {
        int res = a + b + 100;
        System.out.println(res);
    }


    /**
     * Вот так работает спринг, что-то подобное написано у него под капотом (то что снизу), а я вижу только верхнюю часть.
     */
    public static void main(String[] args) {

        Class calculatorClass = Calculator.class;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\danil\\IdeaProjects\\My_Lessons_Java\\src\\Base\\Reflection\\test.txt"))) {

            String operation = reader.readLine();
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());

            Method[] methods = calculatorClass.getDeclaredMethods();
            boolean processed = false;

            for (Method method : methods) {
                Annotation annotation = method.getAnnotation(MathOperation.class);
                if (annotation == null) continue;

                MathOperation mathOperation = (MathOperation) annotation;
                if (!mathOperation.name().toLowerCase().equals(operation.toLowerCase())) continue;

                System.out.print(mathOperation.name() + "(" + a + ", " + b + ") = ");
                method.invoke(new Calculator(), a, b);
                processed = true;

            }

            if (processed) return;
            throw new NoSuchMethodException();

        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] Файл не обнаружен!");

        } catch (NoSuchMethodException e) {
            System.out.println("[ERROR] Нет такой операции!\n" +
                    "Выберите одну из следующих: ");

            Method[] methods = calculatorClass.getDeclaredMethods();
            for (Method method : methods) {
                Annotation annotation = method.getAnnotation(MathOperation.class);
                if (annotation == null) continue;
                MathOperation mathOperation = (MathOperation) annotation;
                System.out.println("- " + mathOperation.name() + " (" + mathOperation.description() + ")");
            }

        } catch (InvocationTargetException e) {
            System.out.println("[ERROR] Неправильные переменные a и b");

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);

        } catch (Exception exception) {
            System.out.println("[ERROR] Ошибка чтения файла!");
        }
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MathOperation {
    String name();

    String description();

}
