package FRC2115;

import FRC2115.commands.DeployPlunger;
import FRC2115.commands.ExtendArm;
import FRC2115.commands.RetractArm;
import FRC2115.commands.RollRollerUp;
import FRC2115.commands.AutoAlign;
import FRC2115.commands.AutoShooterSpeed;
import FRC2115.commands.RollRollerDown;
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
    
    public JoystickButton plungerButton = new JoystickButton(jGamepad, 8),
            autoShootSpeedButton = new JoystickButton(jAux, 2),
            bridgeUpButton = new JoystickButton(jGamepad,4),
            bridgeDownButton = new JoystickButton(jGamepad, 2),
            rollerUpButton = new JoystickButton(jGamepad, 6), 
            rollerDownButton = new JoystickButton(jGamepad, 5),
            autoAimButton = new JoystickButton(jAux, 3);
    
    public OI()
    {
        plungerButton.whenPressed(new DeployPlunger(0.5));
        bridgeDownButton.whileHeld(new ExtendArm());
        bridgeUpButton.whileHeld(new RetractArm());
        rollerUpButton.whileHeld(new RollRollerUp());
        rollerDownButton.whileHeld(new RollRollerDown());
        autoAimButton.whileHeld(new AutoAlign());
        autoShootSpeedButton.whileHeld(new AutoShooterSpeed());
    }
}
