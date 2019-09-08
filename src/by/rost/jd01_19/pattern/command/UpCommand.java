package by.rost.jd01_19.pattern.command;

public class UpCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Повернуть вверх");
    }

    @Override
    public void rollBack() {

    }
}
