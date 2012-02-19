package Jordan.bau5.FRC2115;

import Jordan.bau5.FRC2115.commands.DeployPlunger;
import Jordan.bau5.FRC2115.commands.ExtendArm;
import Jordan.bau5.FRC2115.commands.RetractArm;
import Jordan.bau5.FRC2115.commands.RollRoller;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI 
{   
    private Joystick j1 = new Joystick(1),
            j2 = new Joystick(2);
    
    public Joystick jLeftWheel = j1;
    public int leftAxis = 2;
    public Joystick jRightWheel = j2;
    public int rightAxis = 2;
    public Joystick jShootSetter = j1;
    public int shootSetAxis = 3;
    
    public JoystickButton plungerButton = new JoystickButton(j1, 1),
            bridgeButton = new JoystickButton(j1, 2),
            rollerButton = new JoystickButton(j1, 3);
    
    public OI()
    {
        plungerButton.whenPressed(new DeployPlunger(0.5));
        bridgeButton.whenPressed(new ExtendArm(2.5, 2.5));
        bridgeButton.whenReleased(new RetractArm(2.5, 2.5));
        rollerButton.whileHeld(new RollRoller());
    }
}
