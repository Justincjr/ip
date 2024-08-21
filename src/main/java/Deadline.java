import java.time.LocalDateTime;

public class Deadline extends Task{
    private final LocalDateTime end;
    public Deadline(String des, String end) {
        super(des);
        this.end = Parse.parseDate(end);
    }

    public Deadline(String des, boolean isMark, String end) {
        super(des);
        this.end = LocalDateTime.parse(end);
        this.isMark = isMark;
    }

    @Override
    public String getDes() {
        return "[D]" + super.getDes() + " (by: " + Parse.formatDate(end) + ")";
    }

    @Override
    public String toString() {
        return String.format("D %d %s | %s", isMark? 1 : 0, des, end);
    }
}
