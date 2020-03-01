import java.text.ParseException;
import java.util.*;

public class Main{
    public static void main(String[] args) throws ParseException, TaskException {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();

        Person p = new Person(1, "Alex");
        Task t = new Task(p, "mdr", date,Status.OPEN);
    }

}
