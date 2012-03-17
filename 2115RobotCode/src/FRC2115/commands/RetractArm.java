package FRC2115.commands;

import FRC2115.subsystems.BridgeArm;

public class RetractArm extends CommandBase
{
    private double m_timeout;
    
    public RetractArm(double time)
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
        arm.retract();
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
