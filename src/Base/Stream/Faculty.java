package Base.Stream;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    String name;
    List<Student> students = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }
    public void add_student(Student st){
        students.add(st);
    }

    public List<Student> get_students(){
        return students;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
