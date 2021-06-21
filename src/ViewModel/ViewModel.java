package ViewModel;

import Commands.TimeSeriesAnomalyDetector;
import Model.Model;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import java.io.File;
import java.util.*;


public class ViewModel extends Observable implements Observer {

    public Model model;

    public File file;
    public HashMap<String, DoubleProperty> displayAttributes;
    public IntegerProperty time_step;
    public TimeSeriesAnomalyDetector anomalyDetector;

    // joystick
    public FloatProperty aileron, elevators, rudder, throttle;

    // buttons
    public DoubleProperty timeSlider, videoTime;
    public FloatProperty speed;
    public Runnable forward, backward, play, pause, stop, fastforward, fastbackward;
    public IntegerProperty trainTSlines , testTSlines;

    // clocks
    public DoubleProperty altimeterValue, headingValue, pitchValue, rollValue, speedValue, yawValue;


    // attList
    public ObservableList attributeslist;

    //files
    public StringProperty trainPath, algoPath, testPath;


    public ViewModel(Model m) {

        this.model = m;
        this.model.addObserver(this);
        displayAttributes = new HashMap<String, DoubleProperty>();
        speed = new SimpleFloatProperty();
        speed.setValue(1.0F);
        time_step = new SimpleIntegerProperty(0);
        this.time_step.bind(model.timestep);


        // joystick
        aileron = new SimpleFloatProperty();
        elevators = new SimpleFloatProperty();
        rudder = new SimpleFloatProperty();
        throttle = new SimpleFloatProperty();

        this.aileron.bind(model.aileron);
       this.elevators.bind(model.elevators);
        this.rudder.bind(model.rudder);
        this.throttle.bind(model.throttle);

        // buttons
        timeSlider = new SimpleDoubleProperty();
        videoTime = new SimpleDoubleProperty();

        play = () -> model.play();
        stop = () -> model.stop();
        pause = () -> model.pause();
        forward = () -> model.forward();
        backward = () -> model.backward();
        fastforward = () -> model.fastforward();
        fastbackward = () -> model.fastbackward();

        time_step.addListener((obs, ov, nv) -> {
            Platform.runLater(() ->
                    timeSlider.setValue(model.timestep.getValue()));

        });
        speed.addListener((obs,ov,nv)->{
            Platform.runLater(()->model.m_speed.setValue(nv));
        });




        //speed.getSelectionModel().selectedIndexProperty().addListener((obs, ov, nv) -> { m.m_speed.setValue(nv); });


        //files
        trainPath = new SimpleStringProperty();
        testPath = new SimpleStringProperty();
        algoPath = new SimpleStringProperty();


        // clocks
        altimeterValue = new SimpleDoubleProperty();
        headingValue = new SimpleDoubleProperty();
        pitchValue = new SimpleDoubleProperty();
        rollValue = new SimpleDoubleProperty();
        speedValue = new SimpleDoubleProperty();
        yawValue = new SimpleDoubleProperty();

        altimeterValue.bind(model.altimeterValue);
        headingValue.bind(model.headingValue);
        pitchValue.bind(model.pitchValue);
        rollValue.bind(model.rollValue);
        speedValue.bind(model.speedValue);
        yawValue.bind(model.yawValue);




        // attList
        attributeslist = FXCollections.observableArrayList();
        trainTSlines = new SimpleIntegerProperty();

        trainPath.addListener((obs, ov, nv) -> {
            model.trainPath.setValue(nv);
            attributeslist.setAll(model.loadCSV());
            trainTSlines.setValue(model.timeSeries.Lines_num);

        });

        testPath.addListener((obs, ov, nv) -> {
            model.trainPath.setValue(nv);
            attributeslist.setAll(model.loadCSV());

        });

        // algoPath.addListener();  do something


    }


   /* public int getTSlines(){

        return model.timeSeries.Lines_num;
    }*/
    public DoubleProperty getProperty(String name) { return displayAttributes.get(name); }

    @Override
    public void update(Observable o, Object arg) {

    }

}
