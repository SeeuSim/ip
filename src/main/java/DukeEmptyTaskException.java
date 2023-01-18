public class DukeEmptyTaskException extends DukeException {
    public static enum TaskType {
        Todo,
        Deadline,
        Event
    }

    public DukeEmptyTaskException(TaskType type) {
        super(String.format("The description of a %s cannot be empty.", type));
    }
}
