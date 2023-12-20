package Base.Stream;


public class Student implements Comparable<Student>{
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



    @Override
    public int compareTo(Student o) {
        return this.course - o.course;
    }

    public int get_course(){
        return course;
    }
}
