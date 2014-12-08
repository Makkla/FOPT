package gui.mvc.spinner;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyChangeListener implements ChangeListener
{

    private JLabel myLabel;

    public MyChangeListener(JLabel myLabel)
    {
        this.myLabel = myLabel;

    }

    @Override
    public void stateChanged(ChangeEvent e)
    {

        myLabel.setText("neuer Wert:"
                + ((JSpinner) e.getSource()).getModel().getValue());

    }

}
