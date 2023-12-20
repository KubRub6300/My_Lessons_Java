package Collection.List;


import java.util.Stack;

/**
 * Устаревший synchronized класс. Использует принцип LIFO (Last In First Out).
 * Не рекомендован для использования.
 * */
public class Stack_Class {
    static void abc1(){
        System.out.println("abc1 starts");
        System.out.println("abc1 ends");
    }

    static void abc2(){
        System.out.println("abc2 starts");
        abc1();
        System.out.println("abc2 ends");
    }

    static void abc3(){
        System.out.println("abc3 starts");
        abc2();
        System.out.println("abc3 ends");
    }


    public static void main(String[] args) {
        System.out.println("main starts");
        abc3();
        System.out.println("main ends");

        Stack<String> stack = new Stack<>();

        stack.push("Oleg");
        stack.push("Danil");
        stack.push("Maxim");
        stack.push("Nikita");

        System.out.println(stack);

        System.out.println(stack.pop());//Выводит последний добавленный элемент и удалит его
        System.out.println(stack);

        System.out.println(stack.peek()); //Выводит последний элемент, но не удаляет его
        System.out.println(stack);

        while (!stack.isEmpty()){//Пока стэк не пуст выводит его элементы и удаляет их
            System.out.println(stack.pop());
            System.out.println(stack);
        }

    }
}
