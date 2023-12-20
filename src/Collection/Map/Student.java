package Collection.Map;

import java.util.Objects;

public final class Student implements Comparable<Student>{
    private final String name;
    private final String firstname;
    private final int course;

    public Student(String name, String firstname, int course) {
        this.name = name;
        this.firstname = firstname;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student students = (Student) o;
        return course == students.course && Objects.equals(name, students.name) && Objects.equals(firstname, students.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstname, course); //Создание hashCod-a определённое в Джава
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}