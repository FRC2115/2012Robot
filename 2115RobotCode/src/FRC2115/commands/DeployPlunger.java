package FRC2115.commands;

public class DeployPlunger extends CommandBase
{
    private double m_timeout;
    
    public DeployPlunger(double timeout) 
    {
        m_timeout = timeout;
        requires(plunger);
    }

    protected void initialize() 
    {
        setTimeout(m_timeout);
    }

    protected void execute() 
    {
        plunger.shoot();
    }

    protected boolean isFinished()
    {
        return isTimedOut();
    }

    protected void end()
    {
        plunger.down();
    }

    protected void interrupted()
    {
        end();
    }
}
