import DukeExceptions.DukeStoreInvalidAccessException;

/**
 * The command that marks a task in the list as not completed.
 *
 * @author SeeuSim
 * AY2223-S2 CS2103T
 */
public class UnmarkCommand extends Command {
    private final int idx;
    public UnmarkCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public void execute(TaskList ts, Ui ui) {
        try {
            ts.unMark(idx - 1);
        } catch (DukeStoreInvalidAccessException e) {
            ui.error(e);
        }
    }
}
