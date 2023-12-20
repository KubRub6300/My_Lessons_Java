package Base.Exceptions;

public class MyException extends Exception{
    public MyException(String description){ //Можно также не создавать конструктор
        super(description);
    }
}
