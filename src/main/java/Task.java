import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task {
    Person owner;
    String description;
    Date date;
    Status status;
    Resolution resolution;

    public Task(Person owner, String description, Date date, Status status) throws TaskException {
        if (date.compareTo(Calendar.getInstance().getTime()) == -1) {
            throw new TaskException("Une tâche ne peut être plannifié dans le passé");
        }
        this.owner = owner;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setDate(Date date) throws TaskException {
        if (date.compareTo(Calendar.getInstance().getTime()) == -1) {
            throw new TaskException("Une tâche ne peut être plannifié dans le passé");
        }
        this.date = date;
    }

    public void cancelStatus() {
        this.status = Status.CANCELED;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "Task : " +
                "owner=" + owner +
                ", description='" + description + '\'' +
                ", date='" + formatter.format((date)) + '\'' +
                ", status=" + status +
                ", resolution=" + resolution;
    }
}
