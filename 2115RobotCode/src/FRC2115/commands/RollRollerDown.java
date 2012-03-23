package FRC2115.commands;

public class RollRollerDown extends CommandBase
{    
    public RollRollerDown() 
    {
        requires(roller);
    }

    protected void initialize()
    {
        
    }

    protected void execute() 
    {
        roller.rollDown();
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
