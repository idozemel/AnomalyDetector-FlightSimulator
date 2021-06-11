package View.clocks;

import View.files.MyFilesController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyClocks   extends AnchorPane {

    public Label AltitudeValue;
    public Label DirectionValue;
    public Label PitchValue;
    public Label RollValue;
    public Label speedValue;
    public Label yawValue;
    public MyClocksController myCcontroller;

    public MyClocks() {
        super();
        try {
            FXMLLoader fxl = new FXMLLoader();
            AnchorPane ap = fxl.load(getClass().getResource("Clocks.fxml").openStream());
            myCcontroller = fxl.getController();

            this.AltitudeValue = this.myCcontroller.AltitudeValue;
            this.DirectionValue = this.myCcontroller.DirectionValue;
            this.PitchValue = this.myCcontroller.PitchValue;
            this.RollValue = this.myCcontroller.RollValue;
            this.speedValue = this.myCcontroller.speedValue;
            this.yawValue = this.myCcontroller.yawValue;

            this.getChildren().add(ap);

        } catch (IOException e) { e.printStackTrace(); }


    }
}
