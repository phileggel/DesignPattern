package pattern.builder;

/**
 * Created by Phil on 05/07/2014.
 */

// Defines the methods needed for creating parts
// for the robot

public interface RobotBuilder {

    public void buildRobotHead();
    public void buildRobotTorso();
    public void buildRobotArms();
    public void buildRobotLegs();

    public Robot getRobot();

}