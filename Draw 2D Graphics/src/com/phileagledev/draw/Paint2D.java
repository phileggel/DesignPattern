package com.phileagledev.draw;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

/**
 * Created by Phil on 26/06/2014.
 */

@SuppressWarnings("serial")
public class Paint2D extends JFrame {

    private JButton mBtnBrush, mBtnLine, mBtnEllipse, mBtnRect, mBtnStroke, mBtnFill;
    private int mCurrentAction = 1;
    private Color mStrokeColor = Color.BLACK, mFillColor = Color.BLACK;

    private JSlider transSlider;
    private JLabel transLabel;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private float transparentValue = 1.0f;

    private Graphics2D graphSettings;


    public static void main(String[] args) {

        new Paint2D();
    }

    public Paint2D() {

        this.setSize(800, 600);
        this.setTitle("Java Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();

        Box theBox = Box.createHorizontalBox();
        mBtnBrush = makeMeButtons("./Draw 2D Graphics/resource/brush.png", 1);
        mBtnLine = makeMeButtons("./Draw 2D Graphics/resource/line.png", 2);
        mBtnEllipse = makeMeButtons("./Draw 2D Graphics/resource/ellipse.png", 3);
        mBtnRect = makeMeButtons("./Draw 2D Graphics/resource/rectangle.png", 4);
        
        mBtnStroke = makeMeColorButton("./Draw 2D Graphics/resource/stroke.png", 5, true);
        mBtnFill = makeMeColorButton("./Draw 2D Graphics/resource/brush.png", 6, false);

        theBox.add(mBtnBrush);
        theBox.add(mBtnLine);
        theBox.add(mBtnEllipse);
        theBox.add(mBtnRect);
        theBox.add(mBtnStroke);
        theBox.add(mBtnFill);

        transLabel = new JLabel("Transparent : 1");
        transSlider = new JSlider(1, 99, 99);

        ListenerForSlider listenerForSlider = new ListenerForSlider();
        transSlider.addChangeListener(listenerForSlider);

        theBox.add(transLabel);
        theBox.add(transSlider);

        buttonPanel.add(theBox);
        
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(new DrawingBoard(), BorderLayout.CENTER);

        this.setVisible(true);
    }

    private JButton makeMeButtons(String iconFile, final int actionNum) {

        JButton theButton = new JButton();
        Icon icon = new ImageIcon(iconFile);
        theButton.setIcon(icon);

        theButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mCurrentAction = actionNum;
            }
        });

        return theButton;
    }

    private JButton makeMeColorButton(String iconFile, final int actionNum, final boolean stroke) {


        JButton theButton = new JButton();
        Icon icon = new ImageIcon(iconFile);
        theButton.setIcon(icon);

        theButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (stroke) {
                    mStrokeColor = JColorChooser.showDialog(null, "Pick a Stroke", Color.BLACK);
                } else {
                    mFillColor = JColorChooser.showDialog(null, "Pick a Fill", Color.BLACK);
                }
            }
        });

        return theButton;

    }

    private class DrawingBoard extends Component {

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        ArrayList<Color> shapeFill = new ArrayList<Color>();
        ArrayList<Color> shapeStroke = new ArrayList<Color>();
        ArrayList<Float> transPercent = new ArrayList<Float>();

        Point drawStart, drawEnd;

        public DrawingBoard() {

            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // when the moused is pressed get x & y position
                    if (mCurrentAction != 1) {
                        drawStart = new Point(e.getX(), e.getY());
                        drawEnd = drawStart;
                        repaint();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // create a shape using the starting x & y
                    // and finishing x & y positions
                    if (mCurrentAction != 1) {

                        Shape aShape = null;

                        if (mCurrentAction == 2) {
                            aShape = drawLine(drawStart.x, drawStart.y, e.getX(), e.getY());
                        } else if (mCurrentAction == 3) {
                            aShape = drawEllipse(drawStart.x, drawStart.y, e.getX(), e.getY());
                        } else if (mCurrentAction==4) {
                            aShape = drawRectangle(drawStart.x, drawStart.y, e.getX(), e.getY());
                        }

                        shapes.add(aShape);
                        shapeFill.add(mFillColor);
                        shapeStroke.add(mStrokeColor);
                        transPercent.add(transparentValue);

                        drawStart = null;
                        drawEnd = null;
                        repaint();
                    }
                }
            });

            this.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {

                    if (mCurrentAction == 1) {
                        int x = e.getX();
                        int y = e.getY();

                        Shape shape = null;
                        mStrokeColor = mFillColor;
                        shape = drawBrush(x, y, 5, 5);

                        shapes.add(shape);
                        shapeFill.add(mFillColor);
                        shapeStroke.add(mStrokeColor);
                        transPercent.add(transparentValue);
                    }

                    drawEnd = new Point(e.getX(), e.getY());
                    repaint();
                }
            });
        }

        public void paint(Graphics g) {

            Graphics2D graphSettings = (Graphics2D)g;
            graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

            // defines the line width of the strokes
            graphSettings.setStroke(new BasicStroke(2));

            // Iterators created to cycle through strokes & fills
            Iterator<Color> strokeCounter = shapeStroke.iterator();
            Iterator<Color> fillCounter = shapeFill.iterator();
            Iterator<Float> transCounter = transPercent.iterator();

            for (Shape s : shapes) {
                graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transCounter.next()));

                graphSettings.setPaint(strokeCounter.next());
                graphSettings.draw(s);

                graphSettings.setPaint(fillCounter.next());
                graphSettings.fill(s);
            }

            if (drawStart != null && drawEnd != null) {
                graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40f));
                graphSettings.setPaint(Color.GRAY);

                Shape aShape = null;

                if (mCurrentAction == 2) {
                    aShape = drawLine(drawStart.x, drawStart.y, drawEnd.x, drawEnd.y);
                } else if (mCurrentAction == 3) {
                    aShape = drawEllipse(drawStart.x, drawStart.y, drawEnd.x, drawEnd.y);
                } else if (mCurrentAction==4) {
                    aShape = drawRectangle(drawStart.x, drawStart.y, drawEnd.x, drawEnd.y);
                }

                graphSettings.draw(aShape);

            }

        }

    }

    private Rectangle2D.Float drawRectangle(int x1, int y1, int x2, int y2) {

        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);

        int width = Math.abs(x1-x2);
        int height = Math.abs(y1-y2);

        return new Rectangle2D.Float(x, y, width, height);
    }

    private Ellipse2D.Float drawEllipse(int x1, int y1, int x2, int y2) {

        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);

        int width = Math.abs(x1-x2);
        int height = Math.abs(y1-y2);

        return new Ellipse2D.Float(x, y, width, height);
    }

    private Line2D.Float drawLine(int x1, int y1, int x2, int y2) {

        return new Line2D.Float(x1, y1, x2, y2);
    }

    private Ellipse2D.Float drawBrush(int x, int y, int brushStrokeWidth, int brushStrokeHeight) {
        return new Ellipse2D.Float(x, y, brushStrokeWidth, brushStrokeHeight);
    }

    private class ListenerForSlider implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {

            if (e.getSource() == transSlider) {
                transLabel.setText("Transparent : " +
                    decimalFormat.format(transSlider.getValue() * .01));
                transparentValue = (float)(transSlider.getValue() * .01);
            }

        }
    }
}
