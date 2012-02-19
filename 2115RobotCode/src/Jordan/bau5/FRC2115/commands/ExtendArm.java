package Jordan.bau5.FRC2115.commands;

import Jordan.bau5.FRC2115.subsystems.BridgeArm;
import edu.wpi.first.wpilibj.Timer;

public class ExtendArm extends CommandBase
{
    private Timer m_timer;
    private double m_outTime;
    private double m_timeout;
    
    public ExtendArm(double outTime, double downTime) 
    {
        requires(arm);
        m_timer = new Timer();
        
        m_outTime = outTime;
        //Timeout will be when BOTH phases finish
        m_timeout = outTime + downTime;
    }

    protected void initialize() 
    {
        m_timer.reset();
        m_timer.start();
        setTimeout(m_timeout);
    }

    protected void execute() 
    {
        arm.outExtend();
        
        if(m_timer.get() >= m_outTime)
            //Time to be out finished, so start down too
            arm.downExtend();
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
