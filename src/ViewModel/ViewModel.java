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
    public HashMap<String,DoubleProperty> displayAttributes;
    public IntegerProperty time_step; // לכרוך לסליידר טיסה

    public TimeSeriesAnomalyDetector anomalyDetector; // האגוריתם הנבחר לחריגות

    // joystick
    public DoubleProperty aileron , elevators , rudder , throttle;

    // buttons
    public DoubleProperty timeSlider,videoTime;
    public ChoiceBox<Float> speed;
    public Runnable forward, backward, play, pause , stop ,fastforward, fastbackward;

    // clocks
    public DoubleProperty altimeterValue,headingValue,pitchValue,rollValue,speedValue,yawValue;
    public FloatProperty changeClock;

    // attList
    public ObservableList attributeslist;


    //files
    public StringProperty trainPath,algoPath,testPath;



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

        speed.getSelectionModel().selectedIndexProperty().addListener((obs,ov,nv) ->{
            m.m_speed.setValue(nv);
        });

       /* speed.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv) ->{
            m.m_speed = 3;
            Platform.runLater(()-> model.play(nv));
        });*/




        play=()->model.play();
        stop=()->model.stop();
        pause=()->model.pause();
        forward=()->model.forward();
        backward=()->model.backward();
        fastforward=()->model.fastforward();
        fastbackward=()->model.fastbackward();



        //files
        trainPath=new SimpleStringProperty();
        testPath=new SimpleStringProperty();
        algoPath=new SimpleStringProperty();


        // clocks
        altimeterValue = new SimpleDoubleProperty();
        headingValue = new SimpleDoubleProperty();
        pitchValue = new SimpleDoubleProperty();
        rollValue = new SimpleDoubleProperty();
        speedValue = new SimpleDoubleProperty();
        yawValue = new SimpleDoubleProperty();
        changeClock = new SimpleFloatProperty();

        altimeterValue.bind(model.altimeterValue);
        headingValue.bind(model.headingValue);
        pitchValue.bind(model.pitchValue);
        rollValue.bind(model.rollValue);
        speedValue.bind(model.speedValue);
        yawValue.bind(model.yawValue);
        changeClock.bind(model.changeClock);





                // attList
        attributeslist = FXCollections.observableArrayList();

        trainPath.addListener((obs,ov,nv) ->{
            model.trainPath.setValue(nv);
            attributeslist.setAll( model.loadCSV());
        });

        testPath.addListener((obs,ov,nv) ->{
            model.trainPath.setValue(nv);
            attributeslist.setAll( model.loadCSV());
        });

        // algoPath.addListener();  do something


    }



    public DoubleProperty getProperty(String name){
        return displayAttributes.get(name);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
