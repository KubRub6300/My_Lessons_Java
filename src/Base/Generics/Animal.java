package Base.Generics;

public class Animal {
    int id;
    public Animal(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return String.valueOf(id);
    }
}
