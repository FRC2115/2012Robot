package FRC2115.commands;

import FRC2115.subsystems.BridgeArm;

public class ExtendArm extends CommandBase
{   
    public ExtendArm()
    {
        requires(arm);
    }

    protected void initialize() 
    {
    }

    protected void execute() 
    {
        arm.extend();
    }

    protected boolean isFinished()
    {
        return false;
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
