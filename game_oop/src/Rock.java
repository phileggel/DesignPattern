import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Phil on 28/06/2014.
 */

// Lesson #50
public class Rock extends Polygon {

    // upper left hand corner of the polygon
    int upLeftXPos, upLeftYPos;

    // used to change the direction of the asteroid when
    // it hits something and determines how fast it moves
    int xDirection = 1;
    int yDirection = 1;

    // Define rock height and width
    int rockWidth = 26;
    int rockHeight = 31;

    // Copy of the rock ArrayList
    // Holds every Rock I create
    public static ArrayList<Rock> rocks = new ArrayList<Rock>();

    int width = GameBoard.boardWidth;
    int height = GameBoard.boardHeight;

    // will hold the x & y coordinates for the polygon
    int[] polyXArray, polyYArray;

    // x & y positions available for other methods
    public static int[] sPolyXArray = {10, 17, 26, 34, 27, 36, 26, 14, 8, 1, 5, 1, 10};
    public static int[] sPolyYArray = {0, 5, 1, 8, 13, 20, 31, 28, 31, 22, 16, 7, 0};

    String explodeFile = "file:E:\\DEV\\IdeaIDE\\BaniasExample\\game_oop\\sound\\explode.wav";
    boolean onScreen;

    public Rock(int[] polyXArray, int[] polyYArray, int pointsInPoly, int randomStartXPos, int randomStartYPos) {
        super(polyXArray, polyYArray, pointsInPoly);

        this.xDirection = (int)(Math.random() * 4 + 1);
        this.yDirection = (int)(Math.random() * 4 + 1);

        this.upLeftXPos = randomStartXPos;
        this.upLeftYPos = randomStartYPos;

        onScreen = true;
    }

    public Rectangle getBounds() {
        return new Rectangle(super.xpoints[0], super.ypoints[0], rockWidth, rockHeight);
    }

    public void move(SpaceShip theShip, ArrayList<PhotonTorpedo> torpedos) {

        Rectangle rockToCheck = this.getBounds();

        for (Rock rock : rocks) {

            if (rock.onScreen) {
                Rectangle otherRock = rock.getBounds();

                if (rock != this && otherRock.intersects(rockToCheck)) {
                    int tempXDirection = this.xDirection;
                    int tempYDirection = this.yDirection;

                    this.xDirection = rock.xDirection;
                    this.yDirection = rock.yDirection;

                    rock.xDirection = tempXDirection;
                    rock.yDirection = tempYDirection;
                }

                Rectangle shipBox = theShip.getBounds();
                if (otherRock.intersects(shipBox)) {

                    GameBoard.playSoundEffect(explodeFile);

                    theShip.setCenterX(theShip.gBWidth / 2);
                    theShip.setCenterY(theShip.gBHeight / 2);

                    theShip.setXVelocity(0);
                    theShip.setYVelocity(0);
                }

                for (PhotonTorpedo torpedo : torpedos) {

                    if (torpedo.onScreen) {

                        if (otherRock.contains(torpedo.getCenterX(), torpedo.getCenterY())) {

                            rock.onScreen = false;
                            torpedo.onScreen = false;

                            GameBoard.playSoundEffect(explodeFile);

                        }

                    }

                }

            }


        }



        int uLeftXPos = super.xpoints[0];
        int uLeftYPos = super.ypoints[0];

        if (uLeftXPos < 0 || (uLeftXPos + 25) > width) {
            xDirection = -xDirection;
        }

        if (uLeftYPos < 0 || (uLeftYPos + 50) > height) {
            yDirection = -yDirection;
        }

        for (int i = 0; i < super.xpoints.length; i++) {
            super.xpoints[i] += xDirection;
            super.ypoints[i] += yDirection;
        }

    }

    public static int[] getPolyXArray(int randomStartXPos) {

        int[] tempPolyXArray = (int[])sPolyXArray.clone();

        for (int i = 0; i < tempPolyXArray.length; i++) {
            tempPolyXArray[i] += randomStartXPos;
        }

        return tempPolyXArray;
    }

    public static int[] getPolyYArray(int randomStartYPos) {

        int[] tempPolyYArray = (int[])sPolyYArray.clone();

        for (int i = 0; i < tempPolyYArray.length; i++) {
            tempPolyYArray[i] += randomStartYPos;
        }

        return tempPolyYArray;
    }

}
