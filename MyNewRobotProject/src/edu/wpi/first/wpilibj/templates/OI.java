
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.DriveInASquare;

public class OI 
{
    public static final int JOYSTICK_PORT = 1;
    private Joystick stick;
    private JoystickButton trigger;
    
    public OI()
    {
        trigger = new JoystickButton(stick, Joystick.ButtonType.kTop.value);
        trigger.whenPressed(new DriveInASquare());
        stick = new Joystick(JOYSTICK_PORT);
    }
    
    public Joystick getJoystick()
    {
        return stick;
    }
    // Process operator interface input here.
}

