package albert.practice.designPattern.command;

public class GoAheadCommand implements Command {
    
    private Robot robot;
    
    public GoAheadCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        this.robot.goAhead();
    }

}
