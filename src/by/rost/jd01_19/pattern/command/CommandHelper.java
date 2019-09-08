package by.rost.jd01_19.pattern.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class CommandHelper {

    private Deque<Command> commands = new ArrayDeque<>();

    public void run() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void add(Command command) {
        this.commands.addLast(command);
    }

    public void rollBack() {
        Optional.ofNullable(this.commands.pollLast())
                .ifPresent(command -> command.rollBack());
    }
}
