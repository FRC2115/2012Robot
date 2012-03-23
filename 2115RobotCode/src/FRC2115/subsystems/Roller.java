package FRC2115.subsystems;

import FRC2115.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Roller extends Subsystem 
{
    //Speed that the roller should roll when going forward
    public static final double ROLLER_SPEED = -0.7;
    private Jaguar j;
    
    public Roller()
    {
        j = new Jaguar(RobotMap.rollerMotor);
    }
    public void initDefaultCommand() 
    {
        
    }
    
    public void rollDown()
    {
        j.set(-ROLLER_SPEED);
    }
    public void rollUp()
    {
        j.set(ROLLER_SPEED);
    }
    public void stop()
    {
        j.set(0);
    }
}
