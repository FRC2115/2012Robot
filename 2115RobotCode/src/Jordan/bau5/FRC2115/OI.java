package Jordan.bau5.FRC2115;

import Jordan.bau5.FRC2115.commands.DeployPlunger;
import Jordan.bau5.FRC2115.commands.ExtendArm;
import Jordan.bau5.FRC2115.commands.RetractArm;
import Jordan.bau5.FRC2115.commands.RollRoller;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI 
{   
    public Joystick j1 = new Joystick(1),
            j2 = new Joystick(2);
    
    public JoystickButton plungerButton = new JoystickButton(j1, 1),
            bridgeButton = new JoystickButton(j1, 2),
            rollerButton = new JoystickButton(j1, 3);
    
    public OI()
    {
        plungerButton.whenPressed(new DeployPlunger(0.5));
        bridgeButton.whenPressed(new ExtendArm(1.0, 1.0));
        bridgeButton.whenReleased(new RetractArm(1.0, 1.0));
        rollerButton.whileHeld(new RollRoller());
    }
}
