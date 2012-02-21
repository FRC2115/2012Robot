package FRC2115.subsystems;

import FRC2115.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BridgeArm extends Subsystem
{
    private Solenoid solenoidOut;
    private Solenoid solenoidDown;
    
    public BridgeArm()
    {
        solenoidOut = new Solenoid(RobotMap.armOutSolenoidChannel);
        solenoidDown = new Solenoid(RobotMap.armDownSolenoidChannel);
    }
    
    public void initDefaultCommand()
    {
    }
    
    public void outExtend()
    {
        solenoidOut.set(true);
    }
    
    public void outRetract()
    {
        solenoidOut.set(false);
    }
    
    public void downExtend()
    {
        solenoidDown.set(true);
    }
    
    public void downRetract()
    {
        solenoidDown.set(false);
    }
}
