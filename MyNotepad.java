import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.text.*;

public class MyNotepad extends JFrame {
    private JTextArea textArea;

    public MyNotepad() {
        // Set up the frame
        setTitle("My Notepad");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the text area
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // Create Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        cutItem.addActionListener(e -> textArea.cut());
        copyItem.addActionListener(e -> textArea.copy());
        pasteItem.addActionListener(e -> textArea.paste());

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        menuBar.add(editMenu);

        // Create Format menu
        JMenu formatMenu = new JMenu("Format");
        JMenuItem fontItem = new JMenuItem("Font");

        fontItem.addActionListener(e -> chooseFont());
        formatMenu.add(fontItem);
        menuBar.add(formatMenu);

        // Add the menu bar to the frame
        setJMenuBar(menuBar);
    }

    // Method to open a file
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + e.getMessage());
            }
        }
    }

    // Method to save a file
    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(textArea.getText());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
            }
        }
    }

    // Method to choose a font
    private void chooseFont() {
        Font initialFont = textArea.getFont();
        Font selectedFont = JFontChooser.showDialog(this, "Choose Font", initialFont);
        if (selectedFont != null) {
            textArea.setFont(selectedFont);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyNotepad notepad = new MyNotepad();
            notepad.setVisible(true);
        });
    }
}

// Font Chooser Class
class JFontChooser extends JDialog {
    private static Font selectedFont;
    private JComboBox<String> fontComboBox;
    private JComboBox<Integer> sizeComboBox;

    public static Font showDialog(Component parent, String title, Font initialFont) {
        JFontChooser fontChooser = new JFontChooser(parent, title, initialFont);
        fontChooser.setVisible(true);
        return selectedFont;
    }

    private JFontChooser(Component parent, String title, Font initialFont) {
        setTitle(title);
        setModal(true);
        setSize(400, 200);
        setLocationRelativeTo(parent);

        // Create font and size options
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontComboBox = new JComboBox<>(fontNames);
        fontComboBox.setSelectedItem(initialFont.getFontName());

        Integer[] sizes = { 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 };
        sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.setSelectedItem(initialFont.getSize());

        // Create OK and Cancel buttons
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            String fontName = (String) fontComboBox.getSelectedItem();
            int fontSize = (Integer) sizeComboBox.getSelectedItem();
            selectedFont = new Font(fontName, Font.PLAIN, fontSize);
            dispose();
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            selectedFont = null;
            dispose();
        });

        // Set up the layout
        JPanel panel = new JPanel();
        panel.add(new JLabel("Font:"));
        panel.add(fontComboBox);
        panel.add(new JLabel("Size:"));
        panel.add(sizeComboBox);
        panel.add(okButton);
        panel.add(cancelButton);

        add(panel);
    }
}
