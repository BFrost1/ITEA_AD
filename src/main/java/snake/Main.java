package snake;

import javax.swing.*;

public class Main
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame();
        frame.add(new Panel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SNAKE");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
