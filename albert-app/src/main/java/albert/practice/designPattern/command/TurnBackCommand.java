package albert.practice.designPattern.command;

public class TurnBackCommand implements Command {
    
    private Robot robot;
    
    public TurnBackCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        this.robot.turnBack();
    }

}
