package Base.Override_equals;

public class Animal {
    private int id;

    public Animal(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object obj){// Можно переопределить метод equals определённый классе Object
        Animal otheranimal = (Animal) obj;
        return this.id == otheranimal.id;
    }
}
