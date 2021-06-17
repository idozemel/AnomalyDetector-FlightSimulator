package Model;

import Commands.TimeSeries;
import Commands.TimeSeriesAnomalyDetector;
import ViewModel.ViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.XMLDecoder;
import java.io.*;
import java.net.Socket;
import java.util.*;

public class Model extends Observable {


    public TimeSeries timeSeries;
    public TimeSeriesAnomalyDetector anomalyDetector;
    public Timer timer = null;
    public IntegerProperty timestep;
    public IntegerProperty m_speed;
    public StringProperty TrainPath, AlgoPath, TestPath;


    public Model(IntegerProperty timestep) {
        this.timestep = timestep;
        m_speed = new SimpleIntegerProperty(1);

        TrainPath = new SimpleStringProperty();
        AlgoPath = new SimpleStringProperty();
        TestPath = new SimpleStringProperty();

    }

    public String[] loadCSV(){
        timeSeries = new TimeSeries(this.TrainPath.getValue());
        return timeSeries.name;
    }


    public void play() {

        int s = (int) (1000) / m_speed.getValue();

        if (timer == null) {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {

                   /*

                    System.out.println("sending row " + timestep.get());


                    */




                    // ---------------------------
                    timestep.set(timestep.get() + 1);
                }
            }, 0, s);
        }

        setChanged();
        notifyObservers();
    }

    public void pause() {
        timer.cancel();
        timer = null;
        setChanged();
        notifyObservers();
    }

    public void stop() {
        timer.cancel();
        timer = null;
        timestep.set(0);
        setChanged();
        notifyObservers();
    }

    public void forward() {

        timestep.set(timestep.get() + 20);
        // לבדוק שאנחנו לא בסוף הטיסה
        setChanged();
        notifyObservers();
    }

    public void backward() {
        int st = timestep.get();
        if (st > 20) {
            timestep.set(st - 20);
        } else {
            timestep.set(0);
        }
        // לעשות ELSE נוסף ולבדוק שאנחנו לא בסוף הטיסה
        setChanged();
        notifyObservers();
    }

    public void fastforward() {

        timestep.set(timestep.get() + 50);
        // לבדוק שאנחנו לא בסוף הטיסה
        setChanged();
        notifyObservers();
    }

    public void fastbackward() {
        int st = timestep.get();
        if (st > 50) {
            timestep.set(st - 50);
        } else {
            timestep.set(0);
        }
        // לעשות ELSE נוסף ולבדוק שאנחנו לא בסוף הטיסה
        setChanged();
        notifyObservers();
    }


//-----------------------------------------------------------------------------------------------//


    public void connect() {
        /*
        PUT THIS IN FLIGHTGEAR SETTINGS
        --generic=socket,in,10,127.0.0.1,5400,tcp,playback_small
        --fdm=null
         */

        Socket fg = null;
        try {
            fg = new Socket("localhost", 5400);
            BufferedReader in = new BufferedReader(new FileReader("reg_flight.csv"));
            PrintWriter out = new PrintWriter(fg.getOutputStream());
            String line;
            while ((line = in.readLine()) != null) {
                out.println(line);
                out.flush();
                Thread.sleep(100);
            }
            out.close();
            in.close();
            fg.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void readCSV() {

        //  timeSeries =new TimeSeries(file.getName());

        String[] names = timeSeries.name;
        setChanged();
        notifyObservers();

    }

}
