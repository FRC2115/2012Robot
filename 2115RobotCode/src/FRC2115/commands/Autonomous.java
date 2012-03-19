package FRC2115.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup
{
    public Autonomous()
    {
        addSequential(new AutoAlign());
        addSequential(new AutoShooterSpeed());
        addSequential(new AutoShooterSpeed());
    }
}
