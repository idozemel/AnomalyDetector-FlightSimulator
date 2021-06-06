package ViewModel;

import Commands.TimeSeries;
import Commands.TimeSeriesAnomalyDetector;
import Model.Model;
import javafx.beans.property.*;
import javafx.scene.control.Button;

import java.io.File;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    protected Model model;

    public File file;
    public HashMap<String,FloatProperty> displayAttributes;
    public IntegerProperty time_step; // לכרוך לסליידר טיסה
    public TimeSeries timeSeries;
    public TimeSeriesAnomalyDetector anomalyDetector; // האגוריתם הנבחר לחריגות

    // joystick
    public DoubleProperty aileron , elevators , rudder , throttle;





    // buttons
    public DoubleProperty timeSlider,videoTime; // speed
    public Button Open, forward, backward, play, pause , stop ,fastforward, fastbackward;;


    public ViewModel(Model m) {
        this.model = m;
        this.model.addObserver(this);
        displayAttributes = new HashMap<>();

        time_step = new SimpleIntegerProperty();

      //  this.model.timestep.bind(this.time_step);

        // joystick
        aileron = new SimpleDoubleProperty();
        elevators  = new SimpleDoubleProperty();
        rudder = new SimpleDoubleProperty();
        throttle = new SimpleDoubleProperty();


/*
        aileron.addListener((o,val,nwval)->model.setAileron((float)newval));
        elevators.addListener((o,val,nwval)->model.setElevator((float)newval));
        rudder.addListener((o,val,nwval)->model.setRudder((float)newval));
        throttle.addListener((o,val,nwval)->model.setThrottle((float)newval));
        time_step.addListener((o,ov,nv) -> setTimeStep((int) nv));
*/







        timeSlider = new SimpleDoubleProperty();
        videoTime = new SimpleDoubleProperty();
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
