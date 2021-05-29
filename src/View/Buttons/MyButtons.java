package View.Buttons;

import View.joystick.MyJoystickController;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;


public class MyButtons extends AnchorPane {

    public Button Open, forward, backward, play, pause , stop ,fastforward, fastbackward;
    public DoubleProperty speed;
    public DoubleProperty timeSlider;
    public StringProperty Path;

    public MyButtons() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            AnchorPane ap = fxml.load(getClass().getResource("Buttons.fxml").openStream());
            MyButtonsController MyBcontroller = fxml.getController();

           speed.setValue(Double.parseDouble(MyBcontroller.speed.getText()));
           timeSlider.setValue(MyBcontroller.timeSlider.getValue());
           Path.setValue(MyBcontroller.Path.getValue());



           //    MyJcontroller.moveJoystick();    //

            this.getChildren().add(ap);

        } catch (IOException e) {e.printStackTrace();}
    }




}
