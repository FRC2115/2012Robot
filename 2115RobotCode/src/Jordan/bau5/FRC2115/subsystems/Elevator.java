/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.commands.Shoot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Jordan
 */
public class Elevator extends Subsystem 
{
    Solenoid s;
    private int SOLENOID_CHANNEL;
    
    public Elevator(int channel)
    {
        SOLENOID_CHANNEL = channel;
        s = new Solenoid(SOLENOID_CHANNEL);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Solenoid getSolenoid()
    {
        return s;
    }
    public void initDefaultCommand() 
    {
        setDefaultCommand(new Shoot());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
