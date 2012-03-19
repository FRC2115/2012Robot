package FRC2115.commands;

public class DecreaseShooterSpeed extends CommandBase
{
    
    public DecreaseShooterSpeed()
    {
        requires(shooter);
    }

    protected void initialize()
    {
        shooter.spinWithButton(10);
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
