package albert.practice.designPattern.command;

public class TurnLeftCommand implements Command {

    private Robot robot;
    
    public TurnLeftCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        this.robot.turnLeft();
    }

}
