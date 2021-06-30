package ViewModel;

import Algorithms.CorrelatedFeatures;
import Algorithms.TimeSeriesAnomalyDetector;
import Model.Model;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.*;


public class ViewModel extends Observable implements Observer {

    public Model model;

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
    public StringProperty name1VM;
    public StringProperty name2VM;
    public ObservableList<Float> f1ArrayList;
    public ObservableList<Float> f2ArrayList;
    public FloatProperty valueLinVM;
    public FloatProperty valueCorVM;
    public FloatProperty ValueZSVM;


    public ViewModel(Model m) {
        this.model = m;
        this.model.addObserver(this);

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


        //files
        trainPath = new SimpleStringProperty();
        testPath = new SimpleStringProperty();
        algoPath = new SimpleStringProperty();
        trainTSlines = new SimpleIntegerProperty();


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

        // buttons
        timeSlider = new SimpleDoubleProperty();
        videoTime = new SimpleDoubleProperty();
        speed = new SimpleFloatProperty();
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
                if (index.get() != -1)
                    changeLISTview();
            });
        });
        speed.addListener((obs, ov, nv) -> {
            Platform.runLater(() -> model.m_speed.setValue(nv));
        });


        // attList

        attributeslist = FXCollections.observableArrayList();
        trainPath.addListener((obs, ov, nv) -> {
            model.trainPath.setValue(nv);
            attributeslist.setAll(model.loadCSV());
            trainTSlines.setValue(model.timeSeries.Lines_num);
        });
        testPath.addListener((obs, ov, nv) -> {
            model.trainPath.setValue(nv);
            attributeslist.setAll(model.loadCSV());
        });

        // graphs
        valueLinVM = new SimpleFloatProperty();
        valueCorVM = new SimpleFloatProperty();
        index = new SimpleIntegerProperty(0);
        f1ArrayList = FXCollections.observableArrayList();
        f2ArrayList = FXCollections.observableArrayList();
        name1VM = new SimpleStringProperty();
        name2VM = new SimpleStringProperty();
        index.addListener((obs, ov, nv) -> {
            model.index.setValue(index.get());


        });
        name1VM.addListener((obs, ov, nv) -> {
            CorrelatedFeatures f = model.getCorroletedFeatur(name1VM.getValue());
            if (f != null)
                name2VM.setValue(f.feature2);

        });

        model.name2v.bindBidirectional(name2VM);


        model.valueLinear.addListener((obs, ov, nv) -> {
            Platform.runLater(() -> {
                valueLinVM.setValue(nv);
                f1ArrayList.add(nv.floatValue());
            });
        });

        model.valueCor.addListener((obs, ov, nv) -> {
            Platform.runLater(() -> {
                valueCorVM.setValue(nv);
                f2ArrayList.add(nv.floatValue());
            });

        });


    }


    public void changeLISTview() {
        float a = model.timeSeries.data[time_step.get()][index.get()];
        f1ArrayList.add(a);

        if (name2VM != null) {
            int i = model.getIndexFromTS(name2VM.getName());
            float b = model.timeSeries.data[time_step.get()][i];
            f2ArrayList.add(b);
        }

    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
