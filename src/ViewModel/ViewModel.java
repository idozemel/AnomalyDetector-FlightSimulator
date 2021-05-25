package ViewModel;

import Model.Model;
import com.sun.javafx.scene.control.Properties;
import javafx.beans.property.DoubleProperty;

import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    Model m;
    public DoubleProperty aileron , elevators , rudder , throttle;
    public DoubleProperty speedSlider;
    public Properties Open, forward, backward, play, pause , stop ,fastforward, fastbackward;;



    public ViewModel(Model m) {
        this.m = m;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
