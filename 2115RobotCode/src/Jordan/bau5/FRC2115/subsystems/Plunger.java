package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Plunger extends Subsystem 
{
    Solenoid s;
    
    public Plunger()
    {
        s = new Solenoid(RobotMap.plungerSolenoidChannel);
    }

    public void shoot()
    {
        s.set(true);
    }
    public void down()
    {
        s.set(false);
    }
    public void initDefaultCommand() 
    {
    }
}
