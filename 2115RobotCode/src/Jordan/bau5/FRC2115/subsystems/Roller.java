/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Jordan
 */
public class Roller extends Subsystem 
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static final double ROLLER_SPEED = -0.7;
    private Jaguar j;
    
    public Roller()
    {
        j = new Jaguar(RobotMap.rollerMotor);
    }
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void roll()
    {
        j.set(ROLLER_SPEED);
    }
    public void stop()
    {
        j.set(0);
    }
}
