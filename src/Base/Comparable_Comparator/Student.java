package Base.Comparable_Comparator;


import java.util.Comparator;

public class Student implements Comparable<Student>{
    int id;
    String name;
    String surName;
    int course;

    public Student(int id, String name, String surName, int course) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.course = course;
    }


    @Override
    public int compareTo(Student anotherStudent) {
        return this.id - anotherStudent.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", course=" + course +
                '}';
    }
}

class  CompareName implements Comparator<Student> {

    @Override
    public int compare(Student st1, Student st2) {
        return st1.name.compareTo(st2.name);
    }
}
