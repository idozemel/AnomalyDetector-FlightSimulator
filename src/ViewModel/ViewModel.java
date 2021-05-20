package ViewModel;

import Model.Model;
import javafx.beans.property.DoubleProperty;

import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    Model m;
    public DoubleProperty aileron , elevators , rudder , throttle;



    public ViewModel(Model m) {
        this.m = m;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
