package gui.mvc.spinner;
import java.util.ArrayList;

import javax.swing.SpinnerModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MySpinnerModel implements SpinnerModel
{
    /**
     * Aktueller Wert.
     */
    private long value;
    /**
     * Minimum.
     */
    private long min;
    /**
     * Maximum.
     */
    private long max;
    /**
     * Wert, um den der aktuelle Wert jeweils erhooeht bzw. erniedrigt wird.
     */
    private long increment;
    /**
     * Weitere Attribute, falls noch benötigt.
     */
    private ArrayList<ChangeListener> ChangeListenerList = new ArrayList<ChangeListener>();

    /**
     * Konstruktor. Gehen Sie davon aus, dass alle übergebenen Parameter immer
     * stimmig sind (d.h. min < max und increment > 0). Der Startwert soll min
     * sein.
     */
    public MySpinnerModel(long min, long max, long increment)
    {

        this.value = min;
        this.min = min;
        this.max = max;
        this.increment = increment;

    }

    /**
     * Methode getNextValue. Falls es einen nächsten Wert gibt, muss dieser als
     * Object zurückgeliefert werden, sonst null.
     */
    public Object getNextValue()
    {
        long nextValue = value + increment;

        if (nextValue < max)
        {
            return nextValue;
        } else
        {
            return null;
        }

    }

    /**
     * Methode getPreviousValue. Falls es einen vorigen Wert gibt, muss dieser
     * als Object zurückgeliefert werden, sonst null.
     */
    public Object getPreviousValue()
    {
        long nextValue = value - increment;

        if (nextValue >= min)
        {
            return nextValue;
        } else
        {
            return null;
        }

    }

    /**
     * Methode getValue. Der aktuelle Wert als Object.
     */
    public Object getValue()
    {

        return value;

    }

    /**
     * Methode setValue. Sie können davon ausgehen, dass der Parameter o vom
     * selben Typ ist wie von Ihnen bei getNextValue, getPreviousValue und
     * getValue zurückgeliefert. Es müssen alle angemeldeten Listener
     * benachrichtigt werden.
     */
    public void setValue(Object o)
    {
        this.value = (long) o;

        ChangeEvent e = new ChangeEvent(o);

        for (ChangeListener l : ChangeListenerList)
        {

            l.stateChanged(e);

        }

    }

    /**
     * Registriert einen ChangeListener.
     */
    public void addChangeListener(ChangeListener l)
    {

        ChangeListenerList.add(l);

    }

    /**
     * Meldet einen ChangeListener ab.
     */
    public void removeChangeListener(ChangeListener l)
    {

        ChangeListenerList.remove(l);

    }

}