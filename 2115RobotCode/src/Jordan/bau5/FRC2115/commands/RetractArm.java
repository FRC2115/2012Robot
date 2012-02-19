package Jordan.bau5.FRC2115.commands;

public class RetractArm extends CommandBase
{
    private double m_Timeout;
    
    public RetractArm(double timeOut) 
    {
        requires(arm);
        m_Timeout = timeOut;
    }

    protected void initialize() 
    {
        setTimeout(m_Timeout);
    }

    protected void execute()
    {
    }

    protected boolean isFinished()
    {
        return isTimedOut();
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}
