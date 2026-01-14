import java.util.ArrayList;

public class Person {
    String name;
    String gender;
    int age;
    String position;

    public Person (String name, String gender, int age, String position) {
        this.name =name;
        this.gender = gender;
        this.age = age;
        this.position = position;
    }
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }
}
