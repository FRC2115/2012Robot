package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.RobotMap;
import Jordan.bau5.FRC2115.commands.DownPlunger;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Plunger extends Subsystem 
{
    Solenoid s;
    
    public Plunger()
    {
        s = new Solenoid(RobotMap.solenoidChannel);
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
        setDefaultCommand(new DownPlunger());
    }
}
