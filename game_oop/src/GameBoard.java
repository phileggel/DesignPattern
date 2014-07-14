import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Phil on 28/06/2014.
 */

// Lesson #51
public class GameBoard extends JFrame {
    public final static int FORWARD = 90;
    public final static int BACKWARD = 83;
    public final static int LEFT = 81;
    public final static int RIGHT = 68;

    public static int boardWidth = 1000;
    public static int boardHeight = 800;

    public static boolean keyHeld = false;
    public static int keyHeldCode;

    // ArrayList holds Torpedos
    public static ArrayList<PhotonTorpedo> torpedos = new ArrayList<PhotonTorpedo>();

    String thrustFile = "file:E:\\DEV\\IdeaIDE\\BaniasExample\\game_oop\\sound\\thrust.au";
    String laserFile = "file:E:\\DEV\\IdeaIDE\\BaniasExample\\game_oop\\sound\\laser.aiff";

    public static void main(String[] args) {
        new GameBoard();
    }

    public GameBoard() {

        this.setSize(boardWidth, boardHeight);
        this.setTitle("Java Asteroids");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == FORWARD) {         // z
                    System.out.println("Forward");
                    GameBoard.playSoundEffect(thrustFile);
                    keyHeldCode = e.getKeyCode();
                    keyHeld = true;

                } else if (e.getKeyCode() == BACKWARD) {  // s
                    System.out.println("Backward");

                    keyHeldCode = e.getKeyCode();
                    keyHeld = true;

                } else if (e.getKeyCode() == LEFT) {  // q
                    System.out.println("Left");
                    keyHeldCode = e.getKeyCode();
                    keyHeld = true;
                } else if (e.getKeyCode() == RIGHT) {  // d
                    System.out.println("Right");
                    keyHeldCode = e.getKeyCode();
                    keyHeld = true;
                }

                // check for enter key press to fire torpedo
                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    GameBoard.playSoundEffect(laserFile);
                    torpedos.add(new PhotonTorpedo(
                            GameDrawingPanel.theShip.getShipNoseX(),
                            GameDrawingPanel.theShip.getShipNoseY(),
                            GameDrawingPanel.theShip.getRotationAngle()));
                    System.out.println(torpedos.size());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keyHeld = false;
            }
        });

        GameDrawingPanel gamePanel = new GameDrawingPanel();
        this.add(gamePanel, BorderLayout.CENTER);

        // Used to execute code after a given delay
        // the attribute is corePoolsize : the number of threads to keep in the pool
        // even if they are idle
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

        // Method to execute, initial delay, subsequent delay, time unit
        executor.scheduleAtFixedRate(new RepaintTheBoard(this), 0L, 20L, TimeUnit.MILLISECONDS);

        this.setVisible(true);
    }

    public static void playSoundEffect(String soundToPlay) {

        URL soundLocation = null;

        try {
            soundLocation = new URL(soundToPlay);

            Clip clip = null;
            clip = AudioSystem.getClip();
            AudioInputStream inputStream;

            inputStream = AudioSystem.getAudioInputStream(soundLocation);

            clip.open(inputStream);
            clip.loop(0);
            clip.start();

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class RepaintTheBoard implements Runnable {

    GameBoard theBoard;

    public RepaintTheBoard(GameBoard theBoard) {
        this.theBoard = theBoard;
    }

    @Override
    public void run() {
        theBoard.repaint();
    }
}

class GameDrawingPanel extends JComponent {

    public ArrayList<Rock> rocks = new ArrayList<Rock>();

    // modèle de polygone
    int[] polyXArray = Rock.sPolyXArray;
    int[] polyYArray = Rock.sPolyYArray;

    static SpaceShip theShip = new SpaceShip();

    int width = GameBoard.boardWidth;
    int height = GameBoard.boardHeight;

    public GameDrawingPanel() {
        for (int i = 0; i < 10; i++) {

            // position de démarrage
            int randomStartXPos = (int)(Math.random() * (GameBoard.boardWidth - 40) + 1);
            int randomStartYPos = (int)(Math.random() * (GameBoard.boardHeight - 40) + 1);

            // création et ajout du polygone
            rocks.add(new Rock(Rock.getPolyXArray(randomStartXPos), Rock.getPolyYArray(randomStartYPos), 13, randomStartXPos, randomStartYPos));
            Rock.rocks = rocks;
        }
    }

    public void paint(Graphics g) {

        Graphics2D graphicSettings = (Graphics2D)g;

        graphicSettings.setColor(Color.BLACK);
        graphicSettings.fillRect(0, 0, getWidth(), getHeight());

        // set rendering rule
        graphicSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphicSettings.setPaint(Color.WHITE);
        for(Rock rock : rocks) {

            if (rock.onScreen) {
                rock.move(theShip, GameBoard.torpedos);
                graphicSettings.draw(rock);
            }

        }

        if (GameBoard.keyHeld == true && GameBoard.keyHeldCode == GameBoard.RIGHT) {
            theShip.increaseRotationAngle();
        } else if (GameBoard.keyHeld == true && GameBoard.keyHeldCode == GameBoard.LEFT) {
            theShip.decreaseRotationAngle();
        } else if (GameBoard.keyHeld == true && GameBoard.keyHeldCode == GameBoard.FORWARD) {
            theShip.setMovingAngle(theShip.getRotationAngle());
            theShip.increaseXVelocity(theShip.shipXMoveAngle(theShip.getMovingAngle())*0.1);
            theShip.increaseYVelocity(theShip.shipYMoveAngle(theShip.getMovingAngle())*0.1);
        }

        theShip.move();
        AffineTransform identity = new AffineTransform();
        graphicSettings.setTransform(identity);
        graphicSettings.translate(theShip.getCenterX(), theShip.getCenterY());
        graphicSettings.rotate(Math.toRadians(theShip.getRotationAngle()));

        graphicSettings.draw(theShip);

        for (PhotonTorpedo torpedo : GameBoard.torpedos) {
            torpedo.move();

            if (torpedo.onScreen) {
                graphicSettings.setTransform(identity);
                graphicSettings.translate(torpedo.getCenterX(), torpedo.getCenterY());
                graphicSettings.draw(torpedo);
            }
        }

    }

}