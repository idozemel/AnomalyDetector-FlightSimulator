package View.clocks;

import eu.hansolo.medusa.Gauge;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MyClocksController {

    @FXML
    Gauge yawValue;
    @FXML
    Gauge AltitudeValue;
    @FXML
    Gauge DirectionValue;
    @FXML
    Gauge speedValue;
    @FXML
    Gauge PitchValue;
    @FXML
    Gauge RollValue;


    public MyClocksController() {


    }

}
