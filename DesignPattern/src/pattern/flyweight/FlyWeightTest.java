package pattern.flyweight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Pattern FlyWeight. Utiliser lors qu'on manipule une très grande quantité d'objets.
 * L'idée est de partager des objets plutôt que de les créer.
 * Exemple de code
 *
 */
public class FlyWeightTest extends JFrame {

    JButton startDrawing;
    int windowWidth = 1750;
    int windowHeight = 1000;

    Color[] shapeColor = {
            Color.orange,
            Color.red,
            Color.yellow,
            Color.blue,
            Color.pink,
            Color.cyan,
            Color.magenta,
            Color.black,
            Color.gray
    };

    public static void main(String[] args) {
        new FlyWeightTest();
    }

    public FlyWeightTest() {
        this.setSize(windowWidth, windowHeight);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("FlyWeight Test");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        final JPanel drawingPanel = new JPanel();

        startDrawing = new JButton("Draw Stuff");
        contentPane.add(drawingPanel, BorderLayout.CENTER);
        contentPane.add(startDrawing, BorderLayout.SOUTH);

        startDrawing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = drawingPanel.getGraphics();
                long startTime = System.currentTimeMillis();

                for (int i = 0; i < 100000; ++i) {
                    // méthode 1 -> 4200 ms env
                    // g.setColor(getRandColor());
                    // g.fillRect(getRandX(), getRandY(), getRandX(), getRandY());

                    // méthode 2 -> 4200 ms env
                    // MyRect rect = new MyRect(getRandColor(), getRandX(), getRandY(), getRandX(), getRandY());
                    // rect.draw(g);

                    // méthode 3 -> 4200 ms env.
                    // je pense que java a été optimisé pour mieux utiliser la mémoire
                    MyRect rect = RectFactory.getRect(getRandColor());
                    rect.draw(g, getRandX(), getRandY(), getRandX(), getRandY());
                }

                long endTime = System.currentTimeMillis();

                System.out.println("That took " + (endTime - startTime));
            }
        });

        this.add(contentPane);
        this.setVisible(true);

    }

    private Color getRandColor() {

        Random randomGenerator = new Random();
        int randInt = randomGenerator.nextInt(shapeColor.length);
        return shapeColor[randInt];

    }

    private int getRandY() {
        return (int)(Math.random() * windowHeight);
    }

    private int getRandX() {
        return (int)(Math.random() * windowWidth);
    }

}
