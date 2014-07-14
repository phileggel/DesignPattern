import java.awt.*;

/**
 * Created by Phil on 30/06/2014.
 */

// video #58
public class PhotonTorpedo extends Polygon {

    int gBWidth = GameBoard.boardWidth;
    int gBHeight = GameBoard.boardHeight;

    private double centerX = 0, centerY = 0;

    public static int[] polyXArray = { -3, 3, 3, -3, -3};
    public static int[] polyYArray = { -3, -3, 3, 3, -3};

    private int torpedoWidth = 6, torpedoHeight = 6;

    public boolean onScreen = false;

    private double movingAngle = 0;

    private double xVelocity = 5, yVelocity = 5;

    public PhotonTorpedo(double centerX, double centerY, double movingAngle) {

        super(polyXArray, polyYArray, 5);

        System.out.println("centerX " + centerX + " centerY " + centerY + " moving angle :" + movingAngle);

        this.centerX = centerX;
        this.centerY = centerY;
        this.movingAngle = movingAngle;

        this.onScreen = true;

        this.setXVelocity(this.torpedoXMoveAngle(movingAngle) * 10);
        this.setYVelocity(this.torpedoYMoveAngle(movingAngle) * 10);
    }

    public double getXVelocity() { return xVelocity; }
    public double getYVelocity() { return yVelocity; }

    public void setXVelocity(double xVelocity) { this.xVelocity = xVelocity; }
    public void setYVelocity(double yVelocity) { this.yVelocity = yVelocity; }

    public double torpedoXMoveAngle(double movingAngle) {
        return (double)(Math.cos(movingAngle * Math.PI / 180));
    }
    public double torpedoYMoveAngle(double movingAngle) {
        return (double)(Math.sin(movingAngle * Math.PI / 180));
    }

    public double getCenterX() { return centerX; }
    public void setCenterX(double centerX) { this.centerX = centerX; }

    public double getCenterY() { return centerY; }
    public void setCenterY(double centerY) { this.centerY = centerY; }

    public void changeXPos(double incAmt) { this.centerX += incAmt; }
    public void changeYPos(double incAmt) { this.centerY += incAmt; }

    public double getMovingAngle() { return movingAngle; }
    public void setMovingAngle(double movingAngle) { this.movingAngle = movingAngle; }

    public int getTorpedoWidth() { return torpedoWidth; }
    public int getTorpedoHeight() { return torpedoHeight; }

    // collision
    public Rectangle getBounds() {
        return new Rectangle((int)getCenterX() - 6, (int)getCenterY() - 6, getTorpedoWidth(), getTorpedoHeight());
    }

    public void move() {

        if (this.onScreen) {
            this.changeXPos(this.getXVelocity());

            if (this.getCenterX() < 0) {
                this.onScreen = false;
            } else if (this.getCenterX() > gBWidth) {
                this.onScreen = false;
            }

            this.changeYPos(this.getYVelocity());

            if (this.getCenterY() < 0) {
                this.onScreen = false;
            } else if (this.getCenterY() > gBHeight) {
                this.onScreen = false;
            }
        }
    }

}
