package ViewModel;

import Commands.TimeSeriesAnomalyDetector;
import Model.Model;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.scene.chart.LineChart;

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
    public IntegerProperty trainTSlines, testTSlines;

    // clocks
    public DoubleProperty altimeterValue, headingValue, pitchValue, rollValue, speedValue, yawValue;


    // attList
    public ObservableList attributeslist;


    //files
    public StringProperty trainPath, algoPath, testPath;

    //graphs
    public IntegerProperty index;
    public List<String> featuresList;
    public StringProperty Name1VM;
    public StringProperty Name2VM;
    public ObservableList<Float> f1ArrayList;
    public ObservableList<Float> f2ArrayList;
    public ObservableValue<String> name2;
    public DoubleProperty f1Vaule;

    public FloatProperty ValueVM;
    public FloatProperty ValueZSVM;


    public ViewModel(Model m) {

        index = new SimpleIntegerProperty(0);
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

            Platform.runLater(() -> {
                timeSlider.setValue(model.timestep.getValue());

            });
        });
        speed.addListener((obs, ov, nv) -> {
            Platform.runLater(() -> model.m_speed.setValue(nv));
        });





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


        //graphs

        ValueVM = new SimpleFloatProperty();
        ValueZSVM = new SimpleFloatProperty();
        Name1VM = new SimpleStringProperty();
        Name1VM.set("-1");
        Name2VM = new SimpleStringProperty();
        
        Name2VM.set("-1");
        name2 = new SimpleStringProperty();
        f1Vaule = new SimpleDoubleProperty();
        f1ArrayList = FXCollections.observableArrayList();
        f2ArrayList = FXCollections.observableArrayList();

        index.addListener((obs, ov, nv) -> {
            model.index.setValue(index.get());
            if(index.get()!=-1){
                changeLISTview();
            }

        });

        /*model.f1ArrayList.addListener(new ListChangeListener<Float>() {
            @Override
            public void onChanged(Change<? extends Float> c) {
                f1ArrayList.add();
            }
        });*/


    }


    /* public int getTSlines(){

         return model.timeSeries.Lines_num;
     }*/
    public DoubleProperty getProperty(String name) {
        return displayAttributes.get(name);
    }

    public void changeLISTview(){
        float a = model.timeSeries.data[time_step.get()][index.get()];
        System.out.println(" the float is:" + a);
        f1ArrayList.add(a);

        float b = model.timeSeries.data[time_step.get()][index.get()];
        System.out.println(" the float is:" + b);
         f2ArrayList.add(b);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
