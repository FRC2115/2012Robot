package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BridgeArm extends Subsystem
{
    private Solenoid s;
    
    public BridgeArm()
    {
        s = new Solenoid(RobotMap.armSolenoidChannel);
    }
    public void initDefaultCommand()
    {
    }
    
    public void lower()
    {
        s.set(true);
    }
    public void raise()
    {
        s.set(false);
    }
}
