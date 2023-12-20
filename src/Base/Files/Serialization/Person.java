package Base.Files.Serialization;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {//Имплементация Serializable даёт понять Java, что класс можно
    // Сериализовать (записывать в файл объекты этого класса). При этом в интерфейсе Serializable нет никаих методов,
    // такчто не приходится ничего реализовывать.
    @Serial
    private static final long serialVersionUID = 5593593568002131540L; //Записывает номер сериализацици, когда меняшь,
    // что-то существенное в классе, нужно его перезаписывать, тогда при попытке прочтения старого объекта не даст
    // записать его в новый, так как изменится вот этот номер

    private int id;
    private String name;
    private transient String secondname;// transient - указываем Джаве, что не хоти сериализовывать это поле
    // (будет вместо этого записываться null для строк, а для чисел 0)


    public Person(int id, String name, String secondname){
        this.id = id;
        this.name = name;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " : " + name + " " + secondname;
    }
}
