package pattern.adapter;

/**
 * Created by Phil on 15/07/2014.
 */
public class TestEnnemyAttackers {

    public static void main(String[] args) {

        EnnemyTank rx7Tank = new EnnemyTank();
        EnnemyRobot fredTheRobot = new EnnemyRobot();
        EnnemyAttacker robotAdapter = new EnnemyRobotAdapter(fredTheRobot);

        System.out.println("The Robot");

        fredTheRobot.reactToHuman("Paul");
        fredTheRobot.walkForward();
        fredTheRobot.smashWithHands();

        System.out.println("The EnnemyTank");

        rx7Tank.assignDriver("Frank");
        rx7Tank.driveForward();
        rx7Tank.fireWeapon();

        System.out.println("The Robot with Adapter");

        robotAdapter.assignDriver("Mark");
        robotAdapter.driveForward();
        robotAdapter.fireWeapon();


    }

}
