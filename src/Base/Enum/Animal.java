package Base.Enum;

public enum Animal {//Наследник класса Enum
    DOG("Собака"), CAT("Кошка"), FROG("Лягушка"), BIRD("Птица");
    // Это тоже самое что написать new DOG("Собака")
    private String translation;

    Animal(String translation){
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }


    @Override
    public String toString() {
        return name() + " - " + translation;
    }
}
