package Jordan.bau5.FRC2115;

import Jordan.bau5.FRC2115.commands.DeployPlunger;
import Jordan.bau5.FRC2115.commands.LowerArm;
import Jordan.bau5.FRC2115.commands.RollRoller;
import Jordan.bau5.FRC2115.commands.AutoAlign;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI 
{
    public static final int JOYSTICK_ONE_PORT = 1, JOYSTICK_TWO_PORT = 2;
    
    public Joystick j1, j2;
    public JoystickButton plungerButton, bridgeButton, rollerButton, autoAim;
    
    public OI()
    {
        j1 = new Joystick(JOYSTICK_ONE_PORT);
        j2 = new Joystick(JOYSTICK_TWO_PORT);
        plungerButton = new JoystickButton(j1, 1); 
        bridgeButton = new JoystickButton(j1, 2);
        rollerButton = new JoystickButton(j1, 3);
        autoAim = new JoystickButton(j2, 3);
        plungerButton.whenPressed(new DeployPlunger(0.5));
        bridgeButton.whenPressed(new LowerArm(0.5));
        rollerButton.whileHeld(new RollRoller());
        autoAim.whileHeld(new AutoAlign());
    }
}
