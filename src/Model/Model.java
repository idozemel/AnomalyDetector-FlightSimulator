package Model;

import Commands.TimeSeries;
import Commands.TimeSeriesAnomalyDetector;
import ViewModel.ViewModel;
import javafx.beans.property.IntegerProperty;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Model extends Observable {

    ViewModel vm;

    TimeSeries timeSeries;
    public IntegerProperty timestep;
    TimeSeriesAnomalyDetector anomalyDetector;
    
    public void EloimKnows(double x, double y)
    {
        setChanged();
        notifyObservers();
    }
}
