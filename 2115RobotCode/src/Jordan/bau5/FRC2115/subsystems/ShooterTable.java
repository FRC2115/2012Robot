/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.commands.PositionForShooting;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Jordan
 */
public class ShooterTable extends Subsystem 
{
    Jaguar j, j2;
    public ShooterTable()
    {
        j = new Jaguar(1);
        //j2 = new Jaguar(2);
    }
   
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() 
    {
        setDefaultCommand(new PositionForShooting());
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void turn()
    {
        j.set(-.05);
    }
}
