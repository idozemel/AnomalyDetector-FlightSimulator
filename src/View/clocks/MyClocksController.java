package View.clocks;

import eu.hansolo.medusa.Gauge;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MyClocksController {

    @FXML
   public Gauge yawValue;
    @FXML
    public  Gauge altimeterValue;
    @FXML
    public Gauge  headingValue;
    @FXML
    public Gauge  speedValue;
    @FXML
    public Gauge  pitchValue;
    @FXML
    public Gauge  rollValue;


    public MyClocksController() {

     yawValue = new Gauge();
     altimeterValue= new Gauge();
     headingValue= new Gauge();
     speedValue= new Gauge();
     pitchValue= new Gauge();
     rollValue= new Gauge();

    }

}
