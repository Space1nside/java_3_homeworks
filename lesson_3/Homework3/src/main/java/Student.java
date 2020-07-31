import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;

    public Student(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public void info() {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
    }
}
