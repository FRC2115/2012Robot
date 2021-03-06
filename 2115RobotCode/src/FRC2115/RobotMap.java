package FRC2115;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    public static final int leftDriveMotor = 1, 
            rightDriveMotor = 2, 
            shooterMotor = 3, 
            rollerMotor = 4,
            armMotor = 5,
            plungerSolenoidChannel = 1,
            pressureSwitchChannel = 1,
            compressorRelayChannel = 1;
}
