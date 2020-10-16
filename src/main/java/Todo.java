
/**
 * Represents a Todo which extends Task class. A <code>Todo</code> object corresponds to
 * a Todo represented by two Strings
 */
public class Todo extends Task {

    public Todo(String description) {
        super(description.substring(5));
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}