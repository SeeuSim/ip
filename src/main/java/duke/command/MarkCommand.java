package duke.command;

import duke.exceptions.TaskListInvalidAccessException;
import duke.TaskList;
import duke.Ui;

/**
 * The command that marks a task in the list as completed.
 *
 * @author SeeuSim
 * AY2223-S2 CS2103T
 */
public class MarkCommand extends Command {
    private final int idx;
    public MarkCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public void execute(TaskList ts, Ui ui) {
        try {
            ts.mark(idx - 1);
        } catch (TaskListInvalidAccessException e) {
            ui.error(e);
        }
    }
}