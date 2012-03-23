package FRC2115.commands;

public class RollRollerUp extends CommandBase
{    
    public RollRollerUp() 
    {
        requires(roller);
    }

    protected void initialize()
    {
    }

    protected void execute() 
    {
        roller.rollUp();
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
        roller.stop();
    }

    protected void interrupted()
    {
        end();
    }
}
