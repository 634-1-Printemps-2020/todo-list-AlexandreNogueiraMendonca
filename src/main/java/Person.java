import java.util.Objects;

public class Person {
    int ID;
    String name;

    public Person(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return ID == person.ID &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name);
    }

    @Override
    public String toString() {
        return "Person : " +
                "ID=" + ID +
                ", name='" + name + '\'';
    }
}
