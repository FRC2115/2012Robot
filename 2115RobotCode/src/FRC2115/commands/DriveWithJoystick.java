package FRC2115.commands;

public class DriveWithJoystick extends CommandBase
{
    //Adjusts slope of arctan curve
    public static final double slope = Math.PI;
    //Scales arctan curve to the interval [0, 1]
    public static final double scale = 2*arctan(slope/2);
    //Number of times to iterate through recurs, may need to be reduced
    //so as to keep the program running smoothly.
    public static final int precision = 9;
    public DriveWithJoystick() 
    {
        requires(chassis);
    }

    protected void initialize() 
    {
        //Stopping Motor output to ensure correct input on Joysticks
        chassis.drive.setLeftRightMotorOutputs(0, 0);
    }

    protected void execute() 
    {
        double leftAxis = oi.jLeftWheel.getRawAxis(oi.leftAxis);
        double rightAxis = oi.jRightWheel.getRawAxis(oi.rightAxis);
        
        chassis.driveWithJoystick(jMod(leftAxis), jMod(rightAxis));
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
    
    public static double jMod(double jVal)
    {
        //I brought the whole boolean thing back because we can't just
        //multiply the modVal by -1 anymore like we could for cosine.
        boolean isNeg = false;
        if(jVal < 0)
        {
            isNeg = true;
            jVal *= -1;
        }

        double modVal = arctan(slope*(jVal - .5))/scale + .5;
        if(isNeg)
        {
            return modVal * -1;
        }
        return modVal;
    }

    //Precise to at least 3 decimal places for all values
    public static double arctan(double x)
    {
        //Useful little trick for getting past the radius of convergence
        if(x > 1)
            return (Math.PI/2 - arctan(1 / x));
        else if(x < -1)
            return (arctan(1/(-1*x)) - Math.PI/2);
        return x / recurs(x, 1);
    }

    public static double pow(double x, int exp)
    {
        for(int i = 0; i < exp; i++)
        {
            x *= x;
        }
        return x;
    }

    //Uses Gauss's generalized continued fraction form of inverse tangent
    //(it's on Wikipedia). We could also use the Taylor series form (if you're
    //in Calc BC, you'll learn about Taylor Series pretty soon. Or not. I never
    //did, but that was my fault for not doing the homework) which would
    //be easier to write as an iterated loop. I just used this one because
    //it can remain precise past the interval (-1, 1) which is an issue with
    // the Taylor series and we want it to take in values past +/- 1.
    public static double recurs(double x, int n)
    {
        if(n == precision)
        {
            return (2*n-1 + pow((n*x), 2));
        }
        else
        {
            return (2*n-1 + (pow((n*x), 2))/recurs(x, n+1));
        }
    }
}
