import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Ball {
    private int x, y, diameter;
    private int xSpeed, ySpeed;
    private final int panelWidth, panelHeight;

    public Ball(int panelWidth, int panelHeight) {
        this.x = 50; // Starting x position
        this.y = 50; // Starting y position
        this.diameter = 30; // Diameter of the ball
        this.xSpeed = 2; // Horizontal speed
        this.ySpeed = 2; // Vertical speed
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;

        // Bounce off the edges
        if (x < 0 || x + diameter > panelWidth) {
            xSpeed = -xSpeed; // Reverse horizontal direction
        }
        if (y < 0 || y + diameter > panelHeight) {
            ySpeed = -ySpeed; // Reverse vertical direction
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter);
    }
}

public class BouncingBall extends JPanel implements Runnable {
    private Ball ball;

    public BouncingBall() {
        ball = new Ball(600, 400); // Create a ball with the panel dimensions
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.WHITE);

        // Mouse listener to start the ball movement on mouse press
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Thread(BouncingBall.this).start(); // Start the ball animation thread
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g); // Draw the ball
    }

    @Override
    public void run() {
        while (true) {
            ball.move(); // Move the ball
            repaint(); // Repaint the panel
            try {
                Thread.sleep(10); // Sleep for a short interval
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall bouncingBall = new BouncingBall();
        frame.add(bouncingBall);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
