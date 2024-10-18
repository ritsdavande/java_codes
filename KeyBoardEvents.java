import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyBoardEvents extends JFrame implements KeyListener {
    private JTextArea textArea;

    // Constructor to set up the content pane and text area
    public KeyBoardEvents() {
        setTitle("Keyboard Events Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and set up the text area
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.addKeyListener(this); // Add key listener to the text area

        // Add text area to content pane
        getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    // KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {
        textArea.append("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()) + "\n");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        textArea.append("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()) + "\n");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        textArea.append("Key Typed: " + e.getKeyChar() + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KeyBoardEvents frame = new KeyBoardEvents();
            frame.setVisible(true);
        });
    }
}
