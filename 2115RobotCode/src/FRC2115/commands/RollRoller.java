package FRC2115.commands;

public class RollRoller extends CommandBase
{    
    public RollRoller() 
    {
        requires(roller);
    }

    protected void initialize()
    {
    }

    protected void execute() 
    {
        roller.roll();
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
