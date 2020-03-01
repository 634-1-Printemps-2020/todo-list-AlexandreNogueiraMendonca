import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TaskTest {

    private Date date;
    private Calendar c;
    private Person p;

    @Before
    public void createDateAndPerson(){
        date = new Date();
        c = Calendar.getInstance();
        c.setTime(date);
        p = new Person(1, "Alex");
    }

    public Task createTask() throws TaskException {
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        return new Task(p, "mdr", date,Status.OPEN);
    }

    @Test (expected = TaskException.class)
    public void createBadTask() throws TaskException {
        c.add(Calendar.DATE, -10);
        date = c.getTime();
        Task t = new Task(p, "mdr", date,Status.OPEN);
    }

    @Test (expected = TaskException.class)
    public void setDate() throws TaskException {
        Task t = createTask();
        c.add(Calendar.DATE, -2);
        date = c.getTime();
        t.setDate(date);
    }

    @Test
    public void cancelStatus() throws TaskException {
        Task t = createTask();
        t.cancelStatus();
        Assert.assertEquals(t.status.toString(), Status.CANCELED.toString());

    }
}