/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.RobotMap;
import Jordan.bau5.FRC2115.commands.DeployPlunger;
import Jordan.bau5.FRC2115.commands.ShootWithJoyStick;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Jordan
 */
public class Shooter extends Subsystem 
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Jaguar j = new Jaguar(RobotMap.shooterMotor);
    public void initDefaultCommand() 
    {
        setDefaultCommand(new ShootWithJoyStick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void spinWithJoystick(Joystick joystick)
    {
        double joyStickValue = joystick.getZ();
        j.set(((-1 * joyStickValue) + 1) / 2);
    }
}
