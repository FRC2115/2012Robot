package Jordan.bau5.FRC2115.commands;

public class DownPlunger extends CommandBase
{
    public DownPlunger() 
    {
        requires(plunger);
    }

    protected void initialize()
    {
    }
    
    protected void execute() 
    {
        plunger.down();
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}
