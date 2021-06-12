package View.clocks;

import eu.hansolo.medusa.Gauge;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MyClocksController {

    @FXML
   public Gauge yawValue;
    @FXML
    public  Gauge altitudeValue;
    @FXML
    public Gauge  directionValue;
    @FXML
    public Gauge  speedValue;
    @FXML
    public Gauge  pitchValue;
    @FXML
    public Gauge  rollValue;


    public MyClocksController() {

     yawValue = new Gauge();
     altitudeValue= new Gauge();
     directionValue= new Gauge();
     speedValue= new Gauge();
     pitchValue= new Gauge();
     rollValue= new Gauge();

    }

}
