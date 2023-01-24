package duke.command;

import duke.exceptions.DukeException;
import duke.TaskList;
import duke.Ui;

/**
 * The command that represents an error parsing the user given command.
 *
 * @author SeeuSim
 * AY2223-S2 CS2103T
 */
public class ErrorCommand extends Command {
    private final String msg;

    public ErrorCommand(String msg) {
        this.msg = msg;
    }

    public ErrorCommand(DukeException de) {
        this.msg = de.getMessage();
    }

    @Override
    public void execute(TaskList ts, Ui ui) {
        ui.error(new DukeException(msg));
    }
}