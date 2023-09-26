import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Random;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FortuneTellerFrame extends JFrame
{

    int fortuneID = -1;

    Random rnd = new Random();

    String[] wisdoms;

    public void setWisdoms(String[] sayings)
    {
        this.wisdoms = sayings;
    }

    JPanel main = new JPanel();
    JPanel iconPnl = new JPanel();
    JPanel display = new JPanel();
    JPanel controlPnl = new JPanel();

    JLabel title = new JLabel("Great Visionary ");

    ImageIcon fortTellIcon = new ImageIcon("fortune-teller-eye-on-crystal-ba.jpg", "handsome fella");


    JTextArea fortuneTxtArea = new JTextArea(11,55);

    JScrollPane scroller = new JScrollPane(fortuneTxtArea);

    JButton quitBtn = new JButton("Quit");
    JButton fortuneBtn = new JButton("Read my Fortune");

    class fortuneFinder implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int fortuneDex = rnd.nextInt(wisdoms.length);
            boolean done = false;
            while(!done)
            {
                if (fortuneDex == fortuneID)
                    fortuneDex = rnd.nextInt(wisdoms.length);
                else
                {
                    fortuneTxtArea.append(wisdoms[fortuneDex] + "\n");
                    done = true;
                }
            }
            fortuneID = fortuneDex;
        }
    }

    public FortuneTellerFrame()
    {
        main.setLayout(new BorderLayout());

        createIconPanel();
        createDisplayPanel();
        createControlPanel();

        add(main);
    }

    private void createControlPanel()
    {
        controlPnl.setLayout(new GridLayout(1,2));

        controlPnl.add(fortuneBtn);
        fortuneBtn.addActionListener(new fortuneFinder());
        controlPnl.add(quitBtn);
        quitBtn.addActionListener(e -> System.exit(0)
        );

        main.add(BorderLayout.SOUTH, controlPnl);
    }

    private void createDisplayPanel()
    {
        fortuneTxtArea.setFont(new Font("Serif", Font.ITALIC, 18));

        display.add(scroller);

        main.add(BorderLayout.CENTER, display);
    }


    private void createIconPanel()
    {

        title.setFont(new Font("Monospaced", Font.BOLD, 24));
        iconPnl.add(title);


        JLabel image = new JLabel(fortTellIcon);
        iconPnl.add(image);
        main.add(BorderLayout.NORTH, iconPnl);
    }

}
