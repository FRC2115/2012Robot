package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.RobotMap;
import Jordan.bau5.FRC2115.commands.ShootWithJoyStick;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem 
{
    Jaguar j = new Jaguar(RobotMap.shooterMotor);
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new ShootWithJoyStick());
    }
    
    public void spinWithJoystick(Joystick jSet, int axis)
    {
        double joyStickValue = jSet.getRawAxis(axis);
        //Reverse axis because our joystick makes the top -1
        //Then change the range from -1 -> 1 to 0 -> 1
        j.set(((-1 * joyStickValue) + 1) / 2);
    }
}
