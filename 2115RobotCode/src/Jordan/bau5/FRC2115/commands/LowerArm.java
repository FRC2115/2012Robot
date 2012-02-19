package Jordan.bau5.FRC2115.commands;

import Jordan.bau5.FRC2115.subsystems.BridgeArm;

public class LowerArm extends CommandBase
{
    private double m_timeout;
    
    public LowerArm(double timeOut) 
    {
        requires(arm);
        m_timeout = timeOut;
    }

    protected void initialize() 
    {
        setTimeout(m_timeout);
    }

    protected void execute() 
    {
        arm.raise();
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
