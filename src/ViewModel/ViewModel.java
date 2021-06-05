package ViewModel;

import Model.Model;
import com.sun.javafx.scene.control.Properties;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    protected Model m;

    public DoubleProperty aileron , elevators , rudder , throttle;
    public DoubleProperty timeSlider,speed,videoTime;
    public Properties Open, forward, backward, play, pause , stop ,fastforward, fastbackward;;
    public StringProperty path;




    protected DoubleProperty Roll;

    protected DoubleProperty Altimeter;
    protected DoubleProperty Heading;
    protected DoubleProperty Pitch;
    protected DoubleProperty airspeed;
    protected DoubleProperty Yaw;
    protected DoubleProperty playspeed;



    public ViewModel(Model m) {
        this.m = m;

        aileron = new SimpleDoubleProperty();
        elevators  = new SimpleDoubleProperty();
        rudder = new SimpleDoubleProperty();
        throttle = new SimpleDoubleProperty();

        timeSlider = new SimpleDoubleProperty();
        speed = new SimpleDoubleProperty();
        path = new SimpleStringProperty();
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
