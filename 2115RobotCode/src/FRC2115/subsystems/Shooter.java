package FRC2115.subsystems;

import FRC2115.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem 
{
    Jaguar j = new Jaguar(RobotMap.shooterMotor);
    private AnalogChannel us = new AnalogChannel(1, 1);
    private int step = 0;

    
    public void initDefaultCommand() 
    {
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
