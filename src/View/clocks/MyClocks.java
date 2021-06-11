package View.clocks;

import View.files.MyFilesController;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyClocks   extends AnchorPane {

    public DoubleProperty AltitudeValue;
    public DoubleProperty DirectionValue;
    public DoubleProperty PitchValue;
    public DoubleProperty RollValue;
    public DoubleProperty speedValue;
    public DoubleProperty yawValue;
    public MyClocksController myCcontroller;

    public MyClocks() {
        super();
        try {
            FXMLLoader fxl = new FXMLLoader();
            AnchorPane ap = fxl.load(getClass().getResource("Clocks.fxml").openStream());
            myCcontroller = fxl.getController();

            this.AltitudeValue = this.myCcontroller.AltitudeValue.valueProperty();
            this.DirectionValue = this.myCcontroller.DirectionValue.valueProperty();
            this.PitchValue = this.myCcontroller.PitchValue.valueProperty();
            this.RollValue = this.myCcontroller.RollValue.valueProperty();
            this.speedValue = this.myCcontroller.speedValue.valueProperty();
            this.yawValue = this.myCcontroller.yawValue.valueProperty();

            this.getChildren().add(ap);

        } catch (IOException e) { e.printStackTrace(); }


    }
}
