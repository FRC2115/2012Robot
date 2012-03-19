package FRC2115.subsystems;

import FRC2115.RobotMap;
import FRC2115.commands.ShootWithJoyStick;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem 
{
    Jaguar j = new Jaguar(RobotMap.shooterMotor);
    private AnalogChannel us = new AnalogChannel(1, 1);
    private int step = 0;

    
    public void initDefaultCommand() 
    {
        //setDefaultCommand(new ShootWithJoyStick());
    }
    
    public void spinWithJoystick(Joystick jSet, int axis)
    {
        double joyStickValue = jSet.getRawAxis(axis);
        //Reverse axis because our joystick makes the top -1
        //Then change the range from -1 -> 1 to 0 -> 1
        double spinSpeed = ((-1 * joyStickValue) + 1) / 2;
        
        SmartDashboard.putDouble("Shooter Speed", spinSpeed);
        j.set(spinSpeed);
    }
    
    //for testing distance v. shooter speed
    public void spinWithButton(int button)
    {
        if(step < 20 && button == 11)
            step++;
        if(step > -20 && button == 10)
            step--;
        j.set(.05 * step);
        System.out.println(j.get());
    }
    
    //Speed up the shooter based on distance sensor
    public void useRangeSpeed()
    {
        int range = range();
        j.set(distanceAdjust(range));
    }
    
    public int range()
    {
        int usRange = us.getValue() / 2;
        System.out.println("Range: " + usRange);
        return usRange;
    }

    //Maps a ultrasonic range (~inches) to a proper shooter PWM output
    //TEMPORARY IMPLEMENTATION. Needs testing at competition
    public double distanceAdjust(int range)
    {
        return (double)range;
    }
}
