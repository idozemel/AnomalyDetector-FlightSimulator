package Model;

import Commands.TimeSeries;
import Commands.TimeSeriesAnomalyDetector;
import ViewModel.ViewModel;
import javafx.beans.property.IntegerProperty;

import java.beans.XMLDecoder;
import java.io.*;
import java.util.*;

public class Model extends Observable {


    TimeSeries timeSeries;
    TimeSeriesAnomalyDetector anomalyDetector;
    public Timer timer = null;
    public IntegerProperty timestep;

    public Model(IntegerProperty timestep){

        this.timestep=timestep;
    }

    public void play(float speed){
        int s = (int) (speed*1000);
        if(timer==null){
            timer=new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("sending row"+timestep.get());
                    timestep.set(timestep.get()+1);
                }
            },0, s);
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
//------------------Eli the boged------------------------------------//
    public int row,col =0;
    float[][] flightData;
    File csv;

    public void connect() throws IOException, InterruptedException {
        /*
        PUT THIS IN FLIGHTGEAR SETTINGS
        --generic=socket,in,10,127.0.0.1,5400,tcp,playback_small
        --fdm=null
         */

        //fg=new Socket("localhost", 5400);
        //in= new BufferedReader(new FileReader(csv));
        //out=new PrintWriter(fg.getOutputStream());
       /* String line;
        while((line=in.readLine())!=null) {out.println(line);
        out.flush();
        Thread.sleep(100);}
        out.close();
        in.close();
        fg.close();*/
    }

    public void initFlightData(File file) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        for (int i=0;i<line.length();i++) {
            if (line.charAt(i) == ',') {
                col++;
            }
        }
        col++;
        while (line!=null){
            row++;
            line= bufferedReader.readLine();
        }

        flightData = new float[row][col];


    }

    public void readCSV(File file) throws IOException {
        // flightData = new float[2174][42];
        initFlightData(file);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int prevComma=0;
        int countRow = 0;
        int countCol = 0;
        String line = bufferedReader.readLine();
        while (line!=null){
            for (int i=0;i<line.length();i++) {
                if (line.charAt(i) == ',') {


                    flightData[countRow][countCol] = Float.parseFloat(line.substring(prevComma, i));
                    prevComma = i + 1;
                    countCol++;
                }
            }
            prevComma=0;
            countCol=0;
            countRow++;
            line= bufferedReader.readLine();
        }
        csv = file;
        try {
            connect();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setChanged();
        notifyObservers("csv");

    }

}
