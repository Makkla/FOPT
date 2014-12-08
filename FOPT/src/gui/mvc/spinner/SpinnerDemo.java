package gui.mvc.spinner;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.WindowConstants;

public class SpinnerDemo extends JFrame
{

    public SpinnerDemo(String name, long min, long max, long increment)
    {

        super.setName(name);
        MySpinnerModel myModel = new MySpinnerModel(min, max, increment);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JSpinner mySpinner = new JSpinner();
        add(mySpinner, BorderLayout.CENTER);

        mySpinner.setModel(myModel);

        JLabel myLabel = new JLabel("" + min);
        myLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(myLabel, BorderLayout.SOUTH);

        MyChangeListener myChangeListener = new MyChangeListener(myLabel);
        mySpinner.addChangeListener(myChangeListener);

        setSize(200, 100);
        setVisible(true);

    }

    public static void main(String[] args)
    {

        SpinnerDemo SpinnerDemo = new SpinnerDemo("Test", -10, 9, 4);

    }

}
