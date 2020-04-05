import javax.swing.*;

public class visual {
    public static void main(String args[]) {
        IntervalTreap tree = new IntervalTreap();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new visualTest(tree);
            }
        });
    }
}
