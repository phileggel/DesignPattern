package pattern.adapter;

/**
 * Created by Phil on 15/07/2014.
 */

// L'adapter

public class EnnemyRobotAdapter implements EnnemyAttacker {

    // Composition : on créé l'objet EnnemyRobot
    EnnemyRobot theRobot;

    public EnnemyRobotAdapter(EnnemyRobot theRobot) {
        this.theRobot = theRobot;
    }

    @Override
    public void fireWeapon() {
        theRobot.smashWithHands();
    }

    @Override
    public void driveForward() {
        theRobot.walkForward();
    }

    @Override
    public void assignDriver(String driverName) {
        theRobot.reactToHuman(driverName);
    }
}
