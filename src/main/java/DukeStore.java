import java.util.Arrays;

/**
 * The main store class to store user input into the Duke system.
 *
 * @author SeeuSim
 * AY2223-S2 CS2103T
 */
public class DukeStore {
    private static final int recordSize = 100;
    private static int ID = 0;
    private final DukeTask[] records = new DukeTask[recordSize];

    //The unique ID of this store
    private int id;

    // The index of the next available slot to add records.
    private int idx = 0;

    private DukeStore() {
        this.id = DukeStore.ID + 1;
        DukeStore.ID += 1;
    }

    public static DukeStore create() {
        return new DukeStore();
    }

    public void add(String input) throws DukeStoreFullException {
        if (this.idx > recordSize - 1) {
            throw new DukeStoreFullException();
        }
        this.records[this.idx] = new DukeTask(input);
        this.idx += 1;
    }

    public void mark(int i) throws DukeStoreInvalidAccessException {
        if (i < 0 || i >= this.idx) { //Unassigned, invalid index
            throw new DukeStoreInvalidAccessException();
        }
        this.records[i].setDone();
        String message = "Nice! I've marked this task as done:\n" + "  " + this.records[i];
        DukeFormatter.section(message);
    }

    public void unMark(int i) throws DukeStoreInvalidAccessException {
        if (i < 0 || i >= this.idx) { //Unassigned, invalid index
            throw new DukeStoreInvalidAccessException();
        }
        //Index is zero-indexed => Need to subtract one
        this.records[i].markUndone();
        String message = "OK, I've marked this task as not done yet:\n" + "  " + this.records[i];
        DukeFormatter.section(message);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        if (this.idx == 0) {
            return "No records are added yet. Add some by typing them!";
        }
        for (int i = 0; i < this.idx; i++) {
            out.append(String.format("%s. %s\n", i + 1, this.records[i]));
        }
        return out.toString();
    }
}
