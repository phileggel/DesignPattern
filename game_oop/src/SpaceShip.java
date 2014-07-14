import java.awt.*;

/**
 * Created by Phil on 30/06/2014.
 */

// video #56
public class SpaceShip extends Polygon {

    private double xVelocity = 0, yVelocity = 0;
    int gBWidth = GameBoard.boardWidth;
    int gBHeight = GameBoard.boardHeight;

    private double centerX = gBWidth / 2, centerY = gBHeight / 2;

    public static int[] polyXArray = {-13, 14, -13, -5, -13};
    public static int[] polyYArray = {-15, 0, 15, 0, -15};

    private int shipWidth = 27, shipHeight = 30;

    private double uLeftXPos = getCenterX() + this.polyXArray[0];
    private double uLeftYPos = getCenterY() + this.polyYArray[0];

    private double rotationAngle = 0, movingAngle = 0;

    public SpaceShip() {
        super(polyXArray, polyYArray, 5);
    }

    public double getCenterX() { return centerX; }
    public double getCenterY() { return centerY; }

    public void setCenterX(double centerX) { this.centerX = centerX; }
    public void setCenterY(double centerY) { this.centerY = centerY; }

    public void increaseXPos(double incXPos) { this.centerX += incXPos; }
    public void increaseYPos(double incYPos) { this.centerY += incYPos; }

    public double getuLeftXPos() { return uLeftXPos; }
    public double getuLeftYPos() { return uLeftYPos; }

    public void setuLeftXPos(double uLeftXPos) { this.uLeftXPos = uLeftXPos; }
    public void setuLeftYPos(double uLeftYPos) { this.uLeftYPos = uLeftYPos; }

    public int getShipWidth() { return shipWidth; }
    public int getShipHeight() { return shipHeight; }

    public double getXVelocity() { return xVelocity; }
    public double getYVelocity() { return yVelocity; }

    public void setXVelocity(double xVelocity) { this.xVelocity = xVelocity; }
    public void setYVelocity(double yVelocity) { this.yVelocity = yVelocity; }

    public void increaseXVelocity(double incXVel) { this.xVelocity += incXVel; }
    public void increaseYVelocity(double incYVel) { this.yVelocity += incYVel; }

    public void decreaseXVelocity(double decXVel) { this.xVelocity -= decXVel; }
    public void decreaseYVelocity(double decYVel) { this.yVelocity -= decYVel; }

    public double getMovingAngle() { return movingAngle; }
    public void setMovingAngle(double movingAngle) { this.movingAngle = movingAngle; }
    public void increaseMovingAngle(double incMoveAngle) { this.movingAngle += incMoveAngle; }

    public double shipXMoveAngle(double movingAngle) {
        return (double)(Math.cos(movingAngle * Math.PI / 180));
    }
    public double shipYMoveAngle(double movingAngle) {
        return (double)(Math.sin(movingAngle * Math.PI / 180));
    }

    public double getRotationAngle() { return rotationAngle; }

    public void increaseRotationAngle() {
        if (getRotationAngle() >= 355) {
            rotationAngle = 0;
        } else {
            rotationAngle += 5;
        }
    }
    public void decreaseRotationAngle() {
        if (getRotationAngle() < 0) {
            rotationAngle = 355;
        } else {
            rotationAngle -= 5;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getCenterX() - 14, (int)getCenterY() - 14, getShipWidth(), getShipHeight());
    }

    // get spaceship nose vector
    public double getShipNoseX() {
        return this.getCenterX() + Math.cos(rotationAngle * Math.PI / 180) * 14;
    }
    public double getShipNoseY() {
        return this.getCenterY() + Math.sin(rotationAngle * Math.PI / 180) * 14;
    }

    public void move() {

        this.increaseXPos(this.getXVelocity());
        if (this.getCenterX() < 0) {
            this.setCenterX(gBWidth);
        } else if (this.getCenterX() > gBWidth) {
            this.setCenterX(0);
        }

        this.increaseYPos(this.getYVelocity());
        if (this.getCenterY() < 0) {
            this.setCenterY(gBHeight);
        } else if (this.getCenterY() > gBHeight) {
            this.setCenterY(0);
        }
    }

}
