package FRC2115.subsystems;

import FRC2115.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BridgeArm extends Subsystem
{
    private final double speed = 1.0;
    private Jaguar armMotor;
    
    public BridgeArm()
    {
        armMotor = new Jaguar(RobotMap.armMotor);
    }
    
    public void initDefaultCommand()
    {
    }
    
    public void extend()
    {
        armMotor.set(speed);
    }
    
    public void retract()
    {
        armMotor.set(-speed);
    }
    
    public void stop()
    {
        armMotor.set(0);
    }
}
