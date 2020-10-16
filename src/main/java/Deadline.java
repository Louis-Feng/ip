/**
 * Represents a Deadline which extends Task class. A <code>Deadline</code> object corresponds to
 * a Deadline represented by two Strings
 */
public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}