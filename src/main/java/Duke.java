import DukeExceptions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * The main class to run the Duke App.
 *
 * @author SeeuSim
 * AY2223-S2 CS2103T
 */
public class Duke {
//    private static String mascot =
//            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣧⠙⢿⣦⡀⠀⠀⠀⠀⠀⠀⠀⣠⣶⣦⠀⠀⠀⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠙⢿⣦⡀⠀⠀⠀⢀⣾⡿⠉⣿⡄⠀⠀⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠙⣿⣄⣠⣴⡿⠋⠀⠀⣿⡇⠀⠀⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠈⠿⠟⠉⠀⠀⠀⢀⣿⠇⠀⠀⠀⠀⠀\n" +
//            "⠀⠀⠀⣿⡿⠿⠿⠿⠷⣶⣾⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣤⣤⣴⣶⣶⡀\n" +
//            "⠀⠀⠀⠹⣿⡀⠀⠀⠀⠀⠀⠀⢀⡤⠖⠚⠉⠉⠉⠉⠛⠲⣄⠀⠈⠉⠉⠉⠁⣼⡟⠀\n" +
//            "⠀⠀⠀⠀⠹⣷⡀⠀⠀⠀⢀⡔⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⡄⠀⠀⢀⣼⡟⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⢹⣷⠀⠀⢀⡎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡀⢠⣾⡏⠀⠀⠀\n" +
//            "⠀⢀⣠⣴⡾⠟⠋⠀⠀⣸⠀⠀⠀⣴⣒⣒⣛⣛⣛⣋⣉⣉⣉⣙⣛⣷⠀⠙⠿⣶⣤⡀\n" +
//            "⣾⣿⡋⠁⠀⠀⠀⠀⠀⡏⠀⠀⡄⠉⠉⠁⠀⠈⢹⢨⠃⠀⠀⠀⠀⠙⡄⠀⠀⣨⣿⠟\n" +
//            "⠈⠛⠿⣷⣦⣀⠀⠀⠀⡇⠀⠸⡟⠛⠿⠛⠛⠛⢻⢿⠋⠹⠟⠉⠉⠙⡇⣠⣾⠟⠁⠀\n" +
//            "⠀⠀⠀⢀⣽⣿⠇⠀⠀⡇⠀⠀⠳⣄⣀⠀⣀⣠⠞⠈⢷⣄⣀⣀⣠⣾⠁⢿⣧⡀⠀⠀\n" +
//            "⠀⢠⣴⡿⠋⠁⠀⠀⢀⡧⠄⠀⠦⣀⣈⣉⠁⠀⠠⡀⠘⡆⠠⠤⠴⢿⣄⠀⠙⣿⣦⠀\n" +
//            "⠀⠹⢿⣦⣤⣀⠀⢰⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠳⣤⠇⠀⠀⠀⣼⢘⣷⡿⠟⠋⠀\n" +
//            "⠀⠀⠀⠈⠉⣿⡇⠈⠣⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡿⠻⣿⡀⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⢸⣿⣤⣤⣤⣤⢧⠀⢀⡆⣠⠴⠒⠋⢹⠋⠉⢹⠗⠒⠄⣷⣾⡿⠇⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⠉⠉⠉⣿⣇⣈⣆⠀⠳⠤⠀⠀⠀⠈⣇⡖⡍⠀⠠⣾⣿⡿⠇⠀⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⠀⠀⠀⠛⠛⠛⢻⣷⣄⠀⠀⠀⠀⠁⠉⠀⠀⣠⣾⠟⠀⠀⠀⠀⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣉⣿⣷⠲⠤⠤⠤⣤⣶⣿⣟⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⠀⢀⣴⣶⡿⠿⠛⠛⢋⢹⡦⣄⣀⡤⢿⢉⠛⠛⠿⣷⣦⠀⠀⠀⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⠀⣿⠏⠀⠀⠀⠀⢀⠇⠈⡇⠀⠀⠀⠘⡎⣆⠀⠀⠀⢻⣧⠀⠀⠀⠀⠀\n" +
//            "⠀⠀⠀⠀⠀⠈⠿⣶⣶⣶⣶⣶⣾⣶⣾⣷⣶⣶⣶⣶⣷⣾⣷⣶⣶⣾⡿";
    private static String mascot =
            "RICKRICKRICKRICKRICKKKKK\n"
        +   "RICK    RICK    RICKKKKK\n"
        +   "RICKRICKRICKRICKRICKKKKK\n"
        +   "Get Schwifty :)";
    /**
     * The main function that runs the Duke app.
     *
     * @param args Not used as of now. Used mainly to add command line
     *             arguments to the initial app run command.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + mascot);
        greet();
        operate();
    }

    /**
     * The configurable greeting message for the Duke app.
     */
    private static void greet() {
        String name = "R-r-r-rickkk";
        String greeting = String.format("Hello, I'm %s!", name);
        String cta = "What's up?";
        DukeFormatter.section(
                greeting + "\n"
                + cta +"\n"
        );
    }

    /**
     * The cleanup function for the Duke app environment.
     * Closes the provided scanner object.
     *
     * @param sc The command line scanner to close.
     */
    private static void cleanup(Scanner sc) {
        sc.close();
    }

    /**
     * The main function for parsing commands given to the Duke app via the
     * command line.
     *
     * @param cmd The command to be parsed.
     * @param ds The store instance to store any tasks provided via the
     *           command.
     * @param sc The scanner object to scan the command line for inputs.
     */
    private static void parseCommand(String cmd, DukeStore ds, Scanner sc) {
        String[] tokens = cmd.split(" ", 2);
        if (tokens.length == 1) {
            operateSimpleCommand(tokens[0], ds, sc);
            return;
        }

        twoArgCommand(tokens[0], tokens[1], ds);
    }

    /**
     * The main function for parsing commands with one word.
     *
     * @param cmd The command given.
     * @param ds The store instance to store tasks.
     * @param sc The scanner object to scan the command line for inputs.
     */
    private static void operateSimpleCommand(String cmd, DukeStore ds, Scanner sc) {
        switch (cmd) {
            case "bye":
                cleanup(sc);
                String message = "It was okay serving you. Might/might not see you again." + "\n"
                        + "Exiting...";
                DukeFormatter.section(message);
                System.exit(0);

            case "list":
                DukeFormatter.section(ds.toString());
                return;

            case "todo":
                DukeFormatter.error(new DukeEmptyTaskException(DukeEmptyTaskException.TaskType.Todo));
                return;
            case "deadline":
                DukeFormatter.error(new DukeEmptyTaskException(DukeEmptyTaskException.TaskType.Deadline));
                return;
            case "event":
                DukeFormatter.error(new DukeEmptyTaskException(DukeEmptyTaskException.TaskType.Event));
                return;
            default:
                if (cmd.matches("(mark|unmark|delete)")) {
                    DukeFormatter.error(new DukeTaskIndexMissingException(cmd));
                } else {
                    DukeFormatter.error(new DukeInvalidCommandException());
                }
        }
    }

    /**
     * The main function for parsing commands of the following format: `"{command} {param}"`
     *
     * @param cmd The command given.
     * @param param The parameter provided to the command.
     * @param ds The store instance to store tasks.
     */
    private static void twoArgCommand(String cmd, String param, DukeStore ds) {
        switch (cmd) {
            case "todo":
                todo(param, ds);
                return;
            case "deadline":
                deadline(param, ds);
                return;
            case "event":
                event(param, ds);
                return;
            case "tasks":
                filterByDate(param, ds);
                return;

            default:
                if (cmd.matches("(mark|unmark|delete)")) {
                    manipulateTask(cmd, param, ds);
                    return;
                }
                DukeFormatter.error(new DukeInvalidCommandException());
        }
    }

    /**
     * The main access point for manipulating tasks in the store.
     *
     * @param cmd The manipulation command.
     * @param param The access index.
     * @param ds The store instance.
     */
    private static void manipulateTask(String cmd, String param, DukeStore ds) {
        try {
            int idx = Integer.parseInt(param);
            switch (cmd) {
                case "mark":
                    mark(idx, ds);
                    return;
                case "unmark":
                    unMark(idx, ds);
                    return;
                case "delete":
                    delete(idx, ds);
            }
        } catch (NumberFormatException e) {
            DukeFormatter.error(new DukeException(
                    String.format("An invalid index was provided for the %s command."
                            + " Ensure it is a number!", cmd)
            ));
        }

    }

    /**
     * Given a valid index in the store, marks a task as done.
     *
     * @param idx The index of the task in the store.
     * @param ds The store instance to store tasks.
     */
    private static void mark(int idx, DukeStore ds) {
        try {
            ds.mark(idx - 1);
        } catch (DukeStoreInvalidAccessException e) {
            DukeFormatter.error(e);
        }
    }

    /**
     * Given a valid index in the store, marks a task as undone.
     *
     * @param idx The index of the task in the store.
     * @param ds The store instance to store tasks.
     */
    private static void unMark(int idx, DukeStore ds) {
        try {
            ds.unMark(idx - 1);
        } catch (DukeStoreInvalidAccessException e) {
            DukeFormatter.error(e);
        }
    }

    /**
     * Given a valid index in the store, deletes a task stored at that index.
     *
     * @param idx The index of the task in the store.
     * @param ds The store instance to store tasks.
     */
    private static void delete(int idx, DukeStore ds) {
        try {
            ds.delete(idx - 1);
        } catch (DukeStoreInvalidAccessException e) {
            DukeFormatter.error(e);
        }
    }

    /**
     * Given a {@code todo} task, adds it to the store.
     *
     * @param task The {@code todo} task to be added.
     * @param ds The store instance to store tasks.
     */
    private static void todo(String task, DukeStore ds) {
        TaskTodo todo = new TaskTodo(task);
        try {
            ds.add(todo);
        } catch (DukeStoreFullException e) {
            DukeFormatter.error(e);
        }
    }

    /**
     * Given a deadline task command, adds the deadline task to the store.
     *
     * @param command The deadline command.
     * @param ds The store instance to store tasks.
     */
    private static void deadline(String command, DukeStore ds) {
        String[] tokens = command.split(" /by ", 2);
        if (tokens.length != 2) {
            DukeFormatter.guide(
                    "Usage: deadline {task} /by {deadline}"
            );
            return;
        }

        try {
            TaskDeadline deadline = new TaskDeadline(
                    tokens[0],
                    DukeUtils.parseDateTime(tokens[1]));
            ds.add(deadline);
        } catch (DateTimeParseException e) {
            DukeFormatter.error(
                    new DukeInvalidDateException()
            );
        } catch (DukeStoreFullException e) {
            DukeFormatter.error(e);
        }
    }

    /**
     * Given an event task command, adds the event task to the store.
     *
     * @param command The event task command.
     * @param ds The store instance to store tasks.
     */
    private static void event(String command, DukeStore ds) {
        String[] tokens = command.split(" /from ", 2);
        if (tokens.length != 2) {
            DukeFormatter.guide(
                    "Usage: event {task} /from {start} /to {end}"
            );
            return;
        }
        String[] dates = tokens[1].split(" /to ", 2);
        if (dates.length != 2) {
            DukeFormatter.guide(
                    "Usage: event {task} /from {start} /to {end}"
            );
            return;
        }


        try {
            TaskEvent event = new TaskEvent(tokens[0],
                    DukeUtils.parseDateTime(dates[0]),
                    DukeUtils.parseDateTime(dates[1]));
            ds.add(event);
        } catch (DateTimeParseException e) {
            DukeFormatter.error(
                 new DukeInvalidDateException()
            );
        } catch (DukeStoreFullException e) {
            DukeFormatter.error(e);
        }
    }

    /**
     * Filters the DukeStore for tasks occurring on the provided date.
     * @param date The provided date to filter for.
     * @param ds The store instance to store tasks
     */
    private static void filterByDate(String date, DukeStore ds) {

        if (!date.matches("/on (.*)$")) {
            DukeFormatter.error(
                    new DukeException("Usage: tasks /on {day}/{month}/{year}")
            );
            return;
        }
        String cleanedDate = date.replace("/on ", "");
        try {
            LocalDate dt = DukeUtils.parseDate(cleanedDate);
            DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMM yyyy");
            DukeFormatter.section(
                    "Searching for a list of tasks occurring on " + dt.format(df) + ":\n" +
                    ds.occurOnDate(dt)
            );
        } catch (DateTimeParseException e) {
            DukeFormatter.error(
                new DukeInvalidDateException()
            );
        }
    }

    /**
     * The main method by which this store operates
     */
    private static void operate() {
        DukeStore store = DukeStore.create();

        Scanner sc = new Scanner(System.in);
        while (true) {
            String command = sc.nextLine();
            parseCommand(command, store, sc);
        }
    }
}
