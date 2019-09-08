package by.rost.jd01_19.pattern.command;

public class LeftCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Повернуть налево");
    }

    @Override
    public void rollBack() {

    }
}
