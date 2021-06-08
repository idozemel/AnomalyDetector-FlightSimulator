package ViewModel;

import Commands.TimeSeries;
import Commands.TimeSeriesAnomalyDetector;
import Model.Model;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.File;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    protected Model model;

    public File file;
    public HashMap<String,DoubleProperty> displayAttributes;
    public IntegerProperty time_step; // לכרוך לסליידר טיסה
    public TimeSeries timeSeries;
    public TimeSeriesAnomalyDetector anomalyDetector; // האגוריתם הנבחר לחריגות

    // joystick
    public DoubleProperty aileron , elevators , rudder , throttle;

    // buttons
    public DoubleProperty timeSlider,videoTime;
    public ChoiceBox speed;
    public Runnable Open, forward, backward, play, pause , stop ,fastforward, fastbackward;;


    public ViewModel(Model m) {
        this.model = m;
        this.model.addObserver(this);
        displayAttributes = new HashMap<String, DoubleProperty>();

        time_step = new SimpleIntegerProperty(0);

//        model.timestep.bind(this.time_step);
        this.time_step.bind(model.timestep);

        // joystick
        aileron = new SimpleDoubleProperty();
        elevators  = new SimpleDoubleProperty();
        rudder = new SimpleDoubleProperty();
        throttle = new SimpleDoubleProperty();

        // buttons
        timeSlider = new SimpleDoubleProperty();
        videoTime = new SimpleDoubleProperty();
            // ------- //
        displayAttributes.put("aileron",new SimpleDoubleProperty());
        displayAttributes.put("elevator",new SimpleDoubleProperty());
        time_step.addListener((obs,ov,nv) ->{

            Platform.runLater(()-> displayAttributes.get("aileron").set(nv.doubleValue()));
            Platform.runLater(()-> displayAttributes.get("elevator").set(nv.doubleValue()));
        });


        play=()->model.play(1);
        stop=()->model.stop();
        pause=()->model.pause();
        forward=()->model.forward();
        backward=()->model.backward();
        fastforward=()->model.fastforward();
        fastbackward=()->model.fastbackward();
    }

    public DoubleProperty getProperty(String name){
        return displayAttributes.get(name);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
