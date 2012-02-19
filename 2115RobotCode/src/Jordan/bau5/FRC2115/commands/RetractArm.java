package Jordan.bau5.FRC2115.commands;

import Jordan.bau5.FRC2115.subsystems.BridgeArm;
import edu.wpi.first.wpilibj.Timer;

public class RetractArm extends CommandBase
{
    private Timer m_timer;
    private double m_upTime;
    private double m_timeout;
    
    public RetractArm(double upTime, double inTime) 
    {
        requires(arm);
        m_timer = new Timer();
        
        m_upTime = upTime;
        //Timeout will be when BOTH phases finish
        m_timeout = upTime + inTime;
    }

    protected void initialize() 
    {
        m_timer.reset();
        m_timer.start();
        setTimeout(m_timeout);
    }

    protected void execute() 
    {
        arm.downRetract();
        
        if(m_timer.get() >= m_upTime)
            //Should be up by now, so retract completely
            arm.outRetract();
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
