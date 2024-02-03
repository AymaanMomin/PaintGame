//Aymaan Momin & Edward Yan


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PaintGame extends JFrame
        implements ActionListener, MouseMotionListener, MouseListener, MouseWheelListener {


    private JPanel canvas;
    private JButton clearButton;
    private int brushSize = 15;
    private Color brushColor = Color.BLACK;
    private int lastX, lastY;
    private JButton Black = new JButton();
    private JButton Blue = new JButton();
    private JButton Red = new JButton();
    private JButton Yellow = new JButton();
    private JButton White = new JButton();
    private JButton Orange = new JButton();
    private JButton Green = new JButton();
    private JButton Pink = new JButton();
    private JButton Purple = new JButton();
    private JButton Eraser = new JButton("Eraser");


    private JButton blackBackground = new JButton();
    private JButton whiteBackground = new JButton();


    public PaintGame() {
        setTitle("Paint Game");
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
        canvas.setBackground(Color.WHITE);
        canvas.addMouseMotionListener(PaintGame.this);
        canvas.addMouseListener(PaintGame.this);


        clearButton = new JButton("Clear");
        clearButton.addActionListener(PaintGame.this);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearButton);


        Blue.setBackground(Color.BLUE);
        Blue.addActionListener(PaintGame.this);
        Blue.setOpaque(true);
        Blue.setBorderPainted(false);
        buttonPanel.add(Blue);


        Black.setBackground(Color.BLACK);
        Black.addActionListener(PaintGame.this);
        Black.setOpaque(true);
        Black.setBorderPainted(false);
        buttonPanel.add(Black);


        Red.setBackground(Color.RED);
        Red.addActionListener(PaintGame.this);
        Red.setOpaque(true);
        Red.setBorderPainted(false);
        buttonPanel.add(Red);


        Yellow.setBackground(Color.YELLOW);
        Yellow.addActionListener(PaintGame.this);
        Yellow.setOpaque(true);
        Yellow.setBorderPainted(false);
        buttonPanel.add(Yellow);


        White.setBackground(Color.WHITE);
        White.addActionListener(PaintGame.this);
        White.setOpaque(true);
        White.setBorderPainted(false);
        buttonPanel.add(White);


        Orange.setBackground(Color.ORANGE);
        Orange.addActionListener(PaintGame.this);
        Orange.setOpaque(true);
        Orange.setBorderPainted(false);
        buttonPanel.add(Orange);


        Green.setBackground(Color.GREEN);
        Green.addActionListener(PaintGame.this);
        Green.setOpaque(true);
        Green.setBorderPainted(false);
        buttonPanel.add(Green);


        Pink.setBackground(Color.PINK);
        Pink.addActionListener(PaintGame.this);
        Pink.setOpaque(true);
        Pink.setBorderPainted(false);
        buttonPanel.add(Pink);


        Purple.setBackground(Color.MAGENTA);
        Purple.addActionListener(PaintGame.this);
        Purple.setOpaque(true);
        Purple.setBorderPainted(false);
        buttonPanel.add(Purple);


        Eraser.addActionListener(PaintGame.this);
        buttonPanel.add(Eraser);



        JPanel background = new JPanel();
        background.add(blackBackground);
        background.add(whiteBackground);
        blackBackground.setBackground(Color.BLACK);
        blackBackground.setOpaque(true);
        blackBackground.setBorderPainted(false);
        whiteBackground.setBackground(Color.WHITE);
        whiteBackground.setOpaque(true);
        whiteBackground.setBorderPainted(false);
        blackBackground.addActionListener(PaintGame.this);
        whiteBackground.addActionListener(PaintGame.this);


        add(background, BorderLayout.NORTH);


        add(canvas, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        canvas.addMouseWheelListener(PaintGame.this);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            canvas.repaint();
        }
        if (e.getSource() == Blue) {
            brushColor = Color.BLUE;
        }
        if (e.getSource() == Black) {
            brushColor = Color.BLACK;
        }
        if (e.getSource() == Red) {
            brushColor = Color.RED;
        }
        if (e.getSource() == Yellow) {
            brushColor = Color.YELLOW;
        }
        if (e.getSource() == White) {
            brushColor = Color.WHITE;
        }
        if (e.getSource() == Orange) {
            brushColor = Color.ORANGE;
        }
        if (e.getSource() == Green) {
            brushColor = Color.GREEN;
        }
        if (e.getSource() == Pink) {
            brushColor = Color.PINK;
        }
        if (e.getSource() == Purple) {
            brushColor = Color.MAGENTA;
        }
        if (e.getSource() == Eraser) {
            if (canvas.getBackground().equals(Color.WHITE)) {
                brushColor = Color.WHITE;
            }
            if (canvas.getBackground().equals(Color.BLACK)) {
                brushColor = Color.BLACK;
            }
        }
        if (e.getSource() == blackBackground) {
            canvas.setBackground(Color.BLACK);
        }
        if (e.getSource() == whiteBackground) {
            canvas.setBackground(Color.WHITE);
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = canvas.getGraphics();
        g.setColor(brushColor);
        g.fillOval(e.getX() - brushSize / 2, e.getY() - brushSize / 2, brushSize, brushSize);
        lastX = e.getX();
        lastY = e.getY();
    }


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        brushSize += e.getWheelRotation() * 5;
        if (brushSize < 10) {
            brushSize = 10;
        }
    }


    @Override
    public void mouseMoved(MouseEvent e) {
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }


    @Override
    public void mousePressed(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();
    }


    @Override
    public void mouseReleased(MouseEvent e) {
    }


    @Override
    public void mouseEntered(MouseEvent e) {
    }


    @Override
    public void mouseExited(MouseEvent e) {
    }
    public static void main(String[] args) {
        new PaintGame();
    }
}
   







