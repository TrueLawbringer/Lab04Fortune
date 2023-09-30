import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
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

    ImageIcon fortTellIcon = new ImageIcon("fortune-teller-eye-on-crystal-ba.jpg", "handsome fella");
    JLabel title = new JLabel("Great Visionary ", fortTellIcon, JLabel.CENTER);




    JTextArea fortuneTxtArea = new JTextArea(13,65);

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
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
        main.setBackground(new Color(255, 255, 255));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3 * (screenWidth / 4), 3 * (screenHeight / 4));

        createIconPanel();
        createDisplayPanel();
        createControlPanel();

        add(main);
    }

    private void createControlPanel()
    {
        controlPnl.setLayout(new GridLayout(1,2));
        fortuneBtn.setFont(new Font("Plain", Font.PLAIN, 12));
        quitBtn.setFont(new Font("Plain", Font.PLAIN, 12));
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
        iconPnl.setBackground(new Color(255, 255, 255));
        title.setFont(new Font("Monospaced", Font.BOLD, 48));
        title.setForeground(new Color(12, 207, 50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        iconPnl.add(title);

        main.add(BorderLayout.NORTH, iconPnl);
    }

}
