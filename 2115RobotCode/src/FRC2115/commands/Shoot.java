package FRC2115.commands;

public class Shoot extends CommandBase
{
    
    public Shoot()
    {
        requires(shooter);
    }

    protected void initialize()
    {
    }

    protected void execute()
    {
        shooter.actualShoot();
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
