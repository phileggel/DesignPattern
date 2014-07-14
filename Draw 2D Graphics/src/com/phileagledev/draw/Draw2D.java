package com.phileagledev.draw;

/**
 * Created by Phil on 26/06/2014.
 */

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.*;

@SuppressWarnings("serial")

public class Draw2D extends JFrame {

    public static void main(String[] args) {
        new Draw2D();
    }

    public Draw2D() {

        this.setSize(500, 500);
        this.setTitle("Drawing Shapes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new DrawStuff(), BorderLayout.CENTER);
        this.setVisible(true);
    }

    public class DrawStuff extends JComponent {

        public void paint(Graphics g) {

            Graphics2D graph2 = (Graphics2D)g;

            // creating anti-aliasing
            graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            Shape drawLine = new Line2D.Float(20, 90, 55, 250);

            Shape drawArc2DOpen = new Arc2D.Double(5, 150, 100, 100, 45, 45, Arc2D.OPEN);
            Shape drawArc2DChord = new Arc2D.Double(5, 200, 100, 100, 45, 45, Arc2D.CHORD);
            Shape drawArc2DPie = new Arc2D.Double(5, 250, 100, 100, 45, 45, Arc2D.PIE);

            graph2.setPaint(Color.BLACK);

            graph2.draw(drawLine);
            graph2.draw(drawArc2DOpen);
            graph2.draw(drawArc2DChord);
            graph2.draw(drawArc2DPie);

            Shape drawEllipse = new Ellipse2D.Float(10, 10, 100, 100);

            Shape drawRoundRect = new RoundRectangle2D.Double(25, 25, 50, 50, 45, 45);
            Shape drawRect = new Rectangle2D.Float(300, 300, 150, 100);
            Shape drawTransRect = new Rectangle2D.Double(300, 300, 75, 50);

            CubicCurve2D cubicCurve = new CubicCurve2D.Double();
            cubicCurve.setCurve(110, 50, 300, 200, 200, 200, 90, 263);

            Shape drawQuadCurve = new QuadCurve2D.Float(300, 100, 400, 200, 150, 300);

            graph2.draw(drawEllipse);
            graph2.setColor(Color.GREEN);

            graph2.fill(drawRect);

            graph2.setPaint(Color.BLACK);

            graph2.draw(cubicCurve);
            graph2.draw(drawRect);
            graph2.draw(drawQuadCurve);

            graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40F));

            GradientPaint theGradient = new GradientPaint(0, 0, Color.BLUE, 60, 0, new Color(0x66ffffff), true);
            graph2.setPaint(theGradient);

            graph2.fill(new Rectangle2D.Float(10, 10, 150, 100));
            graph2.fill(drawTransRect);

        }


    }


}
