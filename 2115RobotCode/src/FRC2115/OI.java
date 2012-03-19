package FRC2115;

import FRC2115.commands.DeployPlunger;
import FRC2115.commands.ExtendArm;
import FRC2115.commands.RetractArm;
import FRC2115.commands.RollRoller;
import FRC2115.commands.AutoAlign;
import FRC2115.commands.AutoShooterSpeed;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI 
{   
    private Joystick jGamepad = new Joystick(1),
            jAux = new Joystick(2);
    
    public Joystick jLeftWheel = jGamepad;
    public int leftAxis = 2;
    public Joystick jRightWheel = jGamepad;
    public int rightAxis = 3;
    public Joystick jShootSetter = jAux;
    public int shootSetAxis = 3;
    
    public JoystickButton plungerButton = new JoystickButton(jGamepad, 6),
            autoShootSpeedButton = new JoystickButton(jGamepad, 8),
            bridgeButton = new JoystickButton(jGamepad, 9),
            rollerButton = new JoystickButton(jGamepad, 10),
            autoAim = new JoystickButton(jAux, 3);
    
    public OI()
    {
        plungerButton.whenPressed(new DeployPlunger(0.5));
        bridgeButton.whenPressed(new ExtendArm(0.5));
        bridgeButton.whenReleased(new RetractArm(0.5));
        rollerButton.whileHeld(new RollRoller());
        autoAim.whileHeld(new AutoAlign());
        autoShootSpeedButton.whileHeld(new AutoShooterSpeed());
    }
}
