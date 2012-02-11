/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Jordan
 */
public class Plunger extends Subsystem 
{
    Solenoid s;
    
    public Plunger()
    {
        s = new Solenoid(RobotMap.solenoidChannel);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void shoot()
    {
        s.set(true);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
