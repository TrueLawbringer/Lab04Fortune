import javax.swing.*;

public class FortuneTellerViewer
{
    public static void main(String[] args)
    {
        /*Generates wisdoms here so the frame itself is more multipurpose, any amount of visions can
            be used for different themes I went with Warrior Poet styled Fortunes*/
        String[] wisdoms = new String[12];
        wisdoms[0] = "One mark of a great soldier is that a great soldier fights on his own terms or fights not at all.";
        wisdoms[1] = "All men are warriors and life for everything in our universe is nothing but war.";
        wisdoms[2] = "Catch fire with enthusiasm. People will come for miles to watch you burn.";
        wisdoms[3] = "No snowflake in an avalanche ever feels responsible.";
        wisdoms[4] = "Victorious warriors win first and then go to war.";
        wisdoms[5] = "I pity you who must fight even when you cannot win.";
        wisdoms[6] = "Who does not know the evils of war cannot appreciate its benefits.";
        wisdoms[7] = "A sharp mind is best, but a sharp blade makes a close second.";
        wisdoms[8] = "He will win who, prepared himself, waits to take the enemy unprepared.";
        wisdoms[9] = "If your enemy is secure at all points, be prepared for him.";
        wisdoms[10] = "Opportunities multiply as they are seized.";
        wisdoms[11] = "It matters not how many they bring. In the end you will stand and they will all have fallen.";

        FortuneTellerFrame xingTian = new FortuneTellerFrame();
        xingTian.setWisdoms(wisdoms);
        xingTian.setTitle("Xing Tian the Undying");
        xingTian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        xingTian.setVisible(true);


    }
}
