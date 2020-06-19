package GUI;

import javax.swing.*;
import java.awt.*;

public class GuiSub implements Runnable {
    @Override
    public void run() {
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setPreferredSize(new Dimension(999,999));

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        createcontainer(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createcontainer(Container c) {

    }
}
