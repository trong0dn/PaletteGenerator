import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.Math;

/**
 * This class models a palette generator that will generate a random set of colours.
 * @author Trong Nguyen
 * @version 1.0
 */
public class PaletteGenerator {

    private final JFrame frame;
    private final JPanel[] colourPanels = new JPanel[8];
    private final JButton[] colourButtons = new JButton[8];

    /**
     * Constructor for PaletteGenerator.
     */
    public PaletteGenerator() {
        this.frame = new JFrame("Palette Generator");
    }

    /**
     * This method displays the GUI of PaletteGenerator.
     */
    public void displayGUI() {
        // create JLabels
        JLabel headerLabel = new JLabel("Your Palette:");

        // create JPanels
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel headerPanel = new JPanel();
        JPanel bodyPanel = new JPanel(new GridLayout());
        JPanel footerPanel = new JPanel(new GridBagLayout());

        // create JPanel & JButtons
        for (int i = 0; i < 8; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            JButton button = new JButton();
            this.colourPanels[i] = panel;
            this.colourButtons[i] = button;
        }

        // adding JLabels to the respective JPanel
        headerPanel.add(headerLabel);

        // set the preferred sizes
        headerPanel.setPreferredSize(new Dimension(250, 100));
        bodyPanel.setPreferredSize(new Dimension(250, 100));
        footerPanel.setPreferredSize(new Dimension(250, 100));

        // add buttons & colour panels
        for (int i = 0; i < 8; i++) {
            this.colourPanels[i].setBackground(getColour());
            this.colourButtons[i] = getColourButton();
            this.colourButtons[i].doClick();
            this.colourPanels[i].add(this.colourButtons[i], BorderLayout.SOUTH);
            bodyPanel.add(this.colourPanels[i]);
        }

        // add buttons
        footerPanel.add(generatePaletteButton());

        // add JPanels
        mainPanel.add(headerPanel, BorderLayout.PAGE_START);
        mainPanel.add(bodyPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.PAGE_END);

        // pack
        this.frame.add(mainPanel);
        this.frame.pack();

        // add the window listener
        // we no longer want the frame to close immediately when we press "x"
        this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?")
                        == JOptionPane.OK_OPTION) {
                    // close it down!
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });

        // the frame is not visible until we set it to be so
        this.frame.setVisible(true);
    }

    /**
     * Get colours of a certain brightness.
     * @return Color : A Color object with the generated colour.
     */
    private Color getColour() {
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        double luma = (0.2126 * r) + (0.7152 * g) + (0.0722 * b);

        while (luma < 75) {
            r = (int)(Math.random()*256);
            g = (int)(Math.random()*256);
            b = (int)(Math.random()*256);
            luma = (0.2126 * r) + (0.7152 * g) + (0.0722 * b);
        }
        return new Color(r, g, b);
    }

    /**
     * Get an associated lock JButtons that when pressed generates colour palette.
     * The lock button can be unclicked, so if generatePaletteButton is clicked the colour panel will once again change.
     * @return JButton : a JButton object.
     */
    private JButton getColourButton() {
        JButton colourButton = new JButton("X");

        // add the action listener
        colourButton.addActionListener(new ActionListener() {

            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (colourButton.getText().equals("")) {
                    colourButton.setText("X");
                } else {
                    colourButton.setText("");
                }
            }
        });
        return colourButton;
    }

    /**
     * Get a JButton that when can clicked generates a new palette, respectively, for the associated JPanel.
     * @return JButton : a JButton object.
     */
    private JButton generatePaletteButton() {
        JButton generatePaletteButton = new JButton("Generate Palette");

        // add the action listener
        generatePaletteButton.addActionListener(new ActionListener() {

            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < 8; i++) {
                    if (colourButtons[i].getText().equals("")) {
                        colourPanels[i].setBackground(getColour());
                    }
                }
            }
        });
        return generatePaletteButton;
    }
}