/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Jordan
 */
public class BridgeArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Solenoid s;
    
    public BridgeArm()
    {
        s = new Solenoid(RobotMap.armSolenoidChannel);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void lower()
    {
        s.set(true);
    }
    public void raise()
    {
        s.set(false);
    }
}
