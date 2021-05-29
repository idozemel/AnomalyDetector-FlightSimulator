package Model;

import ViewModel.ViewModel;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Model extends Observable {

    ViewModel vm;
    
    public void EloimKnows(double x, double y)
    {
        setChanged();
        notifyObservers();
    }
}
