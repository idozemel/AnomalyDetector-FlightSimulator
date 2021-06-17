package View.clocks;

import View.files.MyFilesController;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyClocks   extends AnchorPane {

    public DoubleProperty altimeterValu;
    public DoubleProperty headingValue;
    public DoubleProperty pitchValue;
    public DoubleProperty rollValue;
    public DoubleProperty speedValue;
    public DoubleProperty yawValue;
    public MyClocksController myCcontroller;

    public MyClocks() {
        super();
        try {
            FXMLLoader fxl = new FXMLLoader();
            AnchorPane ap = fxl.load(getClass().getResource("Clocks.fxml").openStream());
            myCcontroller = fxl.getController();

            altimeterValu = new SimpleDoubleProperty();
            headingValue = new SimpleDoubleProperty();
            pitchValue = new SimpleDoubleProperty();
            rollValue = new SimpleDoubleProperty();
            speedValue = new SimpleDoubleProperty();
            yawValue = new SimpleDoubleProperty();

            //-------

            this.altimeterValu = this.myCcontroller.altimeterValue.valueProperty();
            this.headingValue = this.myCcontroller.headingValue.valueProperty();
            this.pitchValue = this.myCcontroller.pitchValue.valueProperty();
            this.rollValue = this.myCcontroller.rollValue.valueProperty();
            this.speedValue = this.myCcontroller.speedValue.valueProperty();
            this.yawValue = this.myCcontroller.yawValue.valueProperty();

            this.getChildren().add(ap);

        } catch (IOException e) { e.printStackTrace(); }


    }
}
