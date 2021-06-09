package ViewModel;

import Commands.Commands;
import Commands.TimeSeries;
import Commands.TimeSeriesAnomalyDetector;
import Model.Model;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.File;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Handler;

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
    public ChoiceBox<Float> speed;
    public Runnable Open, forward, backward, play, pause , stop ,fastforward, fastbackward;;

    // attList
    public ObservableList attributeslist;


    public ViewModel(Model m) {
        this.model = m;
        this.model.addObserver(this);
        displayAttributes = new HashMap<String, DoubleProperty>();
        speed = new ChoiceBox<>();
        speed.setValue(1.0F);
        time_step = new SimpleIntegerProperty(0);
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

        time_step.addListener((obs,ov,nv) ->{
            Platform.runLater(()-> timeSlider.setValue(model.timestep.getValue()));
        });

        speed.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv) ->{
            Platform.runLater(()-> model.play(nv));
        });



        play=()->model.play(speed.getValue());
        stop=()->model.stop();
        pause=()->model.pause();
        forward=()->model.forward();
        backward=()->model.backward();
        fastforward=()->model.fastforward();
        fastbackward=()->model.fastbackward();



        // attList
        attributeslist = FXCollections.observableArrayList();

       // attributeslist.addAll(timeSeries.getName());


    }

    public DoubleProperty getProperty(String name){
        return displayAttributes.get(name);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
