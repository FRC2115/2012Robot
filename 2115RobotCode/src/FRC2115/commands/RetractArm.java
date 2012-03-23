package FRC2115.commands;

public class RetractArm extends CommandBase
{
    public RetractArm()
    {
        requires(arm);
    }

    protected void initialize() 
    {
    }

    protected void execute() 
    {
        arm.retract();
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
        arm.stop();
    }

    protected void interrupted()
    {
        end();
    }
}
