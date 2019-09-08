package by.rost.jd01_19.pattern.command;

public class RightCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Повернуть направо");
    }

    @Override
    public void rollBack() {

    }
}
