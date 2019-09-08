package by.rost.jd01_19.pattern.command;

public class DownCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Повернуть вниз");
    }

    @Override
    public void rollBack() {

    }
}
