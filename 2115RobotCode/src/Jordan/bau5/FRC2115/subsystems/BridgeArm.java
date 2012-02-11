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
public class BridgeArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Jaguar j;
    
    public BridgeArm()
    {
        j = new Jaguar(RobotMap.armMotor);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void lower()
    {
        j.set(-.1);
    }
    public void raise()
    {
        j.set(.1);
    }
}
