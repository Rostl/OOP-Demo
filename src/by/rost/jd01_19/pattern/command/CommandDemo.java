package by.rost.jd01_19.pattern.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandDemo {

    private static final Map<String, Command> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("l", new LeftCommand());
        COMMANDS.put("r", new RightCommand());
        COMMANDS.put("d", new DownCommand());
        COMMANDS.put("u", new UpCommand());
    }

    public static void main(String[] args) {
        CommandHelper commandHelper = new CommandHelper();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String next = scanner.next();
                Command command = COMMANDS.get(next);
                if (command != null) {
                    commandHelper.add(command);
                } else if ("q".equals(next)) {
                    commandHelper.run();
                    break;
                } else if ("z".equals(next)) {
                    commandHelper.rollBack();
                }
            }
        }
    }
}
