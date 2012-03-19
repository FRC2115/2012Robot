package FRC2115.commands;

public class AutoShooterSpeed extends CommandBase
{
    
    public AutoShooterSpeed()
    {
        requires(shooter);
    }

    protected void initialize()
    {
    }

    protected void execute()
    {
        shooter.useRangeSpeed();
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
