package Base.Lambda;

public class Student {
    public String name;
    public int age;
    public int course;
    public double point;

    public Student(String name, int age, int course, double point) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course=" + course +
                ", point=" + point +
                '}';
    }
}
