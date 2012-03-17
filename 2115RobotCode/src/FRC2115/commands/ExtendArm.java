package FRC2115.commands;

import FRC2115.subsystems.BridgeArm;

public class ExtendArm extends CommandBase
{
    private double m_timeout;
    
    public ExtendArm(double time)
    {
        requires(arm);
        m_timeout = time;
    }

    protected void initialize() 
    {
        setTimeout(m_timeout);
    }

    protected void execute() 
    {
        arm.extend();
    }

    protected boolean isFinished()
    {
        return isTimedOut();
    }

    protected void end()
    {
        arm.stop();
    }

    protected void interrupted()
    {
        end();
    }
}
