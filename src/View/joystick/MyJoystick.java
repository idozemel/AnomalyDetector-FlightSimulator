package View.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MyJoystick extends BorderPane {

   public DoubleProperty aileron , elevators , rudder , throttle; // aileron -  X , elevator - Y
    public MyJoystick() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            BorderPane bd = fxml.load(getClass().getResource("Joystick.fxml").openStream());
            MyJoystickController MyJcontroller = fxml.getController();
            aileron = MyJcontroller.aileron;
            elevators = MyJcontroller.elevators;
            rudder = MyJcontroller.rudder.valueProperty();
            throttle = MyJcontroller.throttle.valueProperty();
            MyJcontroller.moveJoystick();

            this.getChildren().add(bd);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
