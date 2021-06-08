package Model;

import Commands.TimeSeries;
import Commands.TimeSeriesAnomalyDetector;
import ViewModel.ViewModel;
import javafx.beans.property.IntegerProperty;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Model extends Observable {

    ViewModel vm;
    TimeSeries timeSeries;
    TimeSeriesAnomalyDetector anomalyDetector;
    public Timer timer = null;
    public IntegerProperty timestep;

    public Model(IntegerProperty timestep){
        this.timestep=timestep;
    }

    public void play(int speed){
        int s = speed*1000;
        if(timer==null){
            timer=new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("sending row"+timestep.get());
                    timestep.set(timestep.get()+1);
                }
            },0,s);
        }
    }
    public void pause(){
        timer.cancel();
        timer=null;
    }
    public void stop(){
        timer.cancel();
        timer=null;
        timestep.set(0);
    }
    public void forward(){

        timestep.set(timestep.get()+20);
        // לבדוק שאנחנו לא בסוף הטיסה
    }
    public void backward(){
        int st = timestep.get();
        if(st>20){
            timestep.set(st-20);
        }else {
            timestep.set(0);
        }
        // לעשות ELSE נוסף ולבדוק שאנחנו לא בסוף הטיסה
    }
    public void fastforward(){

        timestep.set(timestep.get()+50);
        // לבדוק שאנחנו לא בסוף הטיסה
    }
    public void fastbackward(){
        int st = timestep.get();
        if(st>50){
            timestep.set(st-50);
        }else {
            timestep.set(0);
        }
        // לעשות ELSE נוסף ולבדוק שאנחנו לא בסוף הטיסה
    }

}
