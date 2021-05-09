package ViewModel;

import Model.Model;

import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    Model m;

    public ViewModel(Model m) {
        this.m = m;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
