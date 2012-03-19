package FRC2115.commands;

public class IncreaseShooterSpeed extends CommandBase
{
    
    public IncreaseShooterSpeed()
    {
        requires(shooter);
    }

    protected void initialize()
    {
        shooter.spinWithButton(11);
    }

    protected void execute()
    {
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
