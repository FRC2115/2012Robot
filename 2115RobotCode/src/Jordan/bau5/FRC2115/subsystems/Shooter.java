/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.commands.Shoot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Jordan
 */
public class Shooter extends Subsystem 
{
    private int JAGUAR_1_CHANNEL, JAGUAR_2_CHANNEL;
    private Jaguar j1,j2;
    public Shooter(int jC1, int jC2)
    {
        JAGUAR_1_CHANNEL = jC1;
        JAGUAR_2_CHANNEL = jC2;
        setDefaultCommand(new Shoot());
        j1 = new Jaguar(JAGUAR_1_CHANNEL);
        j2 = new Jaguar(JAGUAR_2_CHANNEL);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void setWheels(double speed)
    {
        j1.set(-speed);
        j2.set(speed);
    }
    public void spinWheels()
    {
        j1.set(-1);
        j2.set(1);
    }
    
    public void shoot()
    {
        
    }
}
