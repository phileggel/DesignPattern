import java.awt.*;

/**
 * Created by Phil on 29/06/2014.
 */

// Lesson #52, #55
public class SpaceShip2 extends Polygon {

    private int upLeftXPos = 500, upLeftYPos = 400;
    int xDirection= 0;
    int yDirection = 0;

    int width = GameBoard.boardWidth;
    int height = GameBoard.boardHeight;

    public static int[] polyXArray = {-13, 14, -13, -5, -13};
    public static int[] polyYArray = {-15, 0, 15, 0, -15};

    static int rotationAngle = 0;

    // area of the ship polygon
    static double areaOfShip;

    public SpaceShip2() {
        super(polyXArray, polyYArray, 5);
        getShipArea();
    }

    public void move() {

        /*
        // get the upper left and top most point for the Polugon
        // this will be dynamic later on
        int uLeftXPos = super.xpoints[0];
        int uLeftYPos = super.ypoints[0];

        // if the rock hits a wall it will go in the opposite direction
        if (uLeftXPos < 0 || (uLeftXPos + 25) > width) {
            xDirection = -xDirection;
        }

        if (uLeftYPos < 0 || (uLeftYPos + 50) > height) {
            yDirection = -yDirection;
        }

        // déplacement du polygon
        for (int i = 0; i < super.xpoints.length; i++) {
            super.xpoints[i] += xDirection;
            super.ypoints[i] += yDirection;
        }
        */

        super.xpoints = SpaceShip2.polyXArray;
        super.ypoints = SpaceShip2.polyYArray;
    }

    // This is here just as a demonstration. IT ISN'T USED

    public void rotateRight() {
        // Calculate the length of the line from 1 vector to the next
        // SQRT ((x1-x2)^2 + (y1-y2)^2)
        // Find the angle of the line from 1 vector to the next
        // x1*x2 + y1*y2 = C
        // SQRT ( x1^2 + x2^2 ) = A
        // SQRT ( y1^2 + y2^2 ) = B
        // ARCCOS ( C / A * B) = Angle of line
        // x2 = x1 + cos(angleOfLine) * length
        // y2 = y1 + sin(angleOfLine) * length

        // How to find new x & y points for the rotating polygon
        // This works on paper, but doesn't with Java because errors occur
        // because we have to convert floats into ints

        /*
	    for(int i = 0; i < super.xpoints.length; i++){

	        polyXArray[i] = this.centerX + (int) ((super.xpoints[i] - this.centerX) * cos(angle) -
	                    (super.ypoints[i] - this.centerY) * sin(angle));

	         polyYArray[i] = this.centerY + (int) ((super.xpoints[i] - this.centerX) * sin(angle) +

	    }
	    */
    }

    public void getShipArea(){

        // Calculate the area of the polygon

        // Temporary sum holder

        double sumHolder1 = 0, sumHolder2 = 0;

        // Find area of polygon
        // Multiply x coordinate of each vertex by the y coordinate
        // of the next vertex. Multiply y coordinate of each vertex
        // by the x coordinate of the next vertex. Subtract these
        // sums and divide by 2 to get the polygons area

        // X Points {-13,14,-13,-5,-13}
        // Y Points {-15,0,15,0,-15}
        // -13 * 0
        //  14 * 15 ... (Do the same for Y)

        for(int i = 0, n = 1; i < 4; i++, n++){

            sumHolder1 += super.xpoints[i] * super.ypoints[n];

        }

        for(int i = 0, n = 1; i < 4; i++, n++){

            sumHolder2 += super.ypoints[i] * super.xpoints[n];

        }

        areaOfShip = Math.abs(sumHolder1 - sumHolder2) / 2;

        System.out.println("Area of Ship: " + areaOfShip);

    }
}
