package View.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MyJoystick extends AnchorPane {

   public DoubleProperty aileron , elevators , rudder , throttle; // aileron -  X , elevator - Y
   public MyJoystickController MyJcontroller;
    public AnchorPane ancp =null;

    public MyJoystick() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            ancp = fxml.load(getClass().getResource("Joystick.fxml").openStream());
             MyJcontroller = fxml.getController();

            aileron = new SimpleDoubleProperty();
            elevators  = new SimpleDoubleProperty();
            rudder = new SimpleDoubleProperty();
            throttle = new SimpleDoubleProperty();

            //
            aileron = MyJcontroller.aileron;
            elevators = MyJcontroller.elevators;
            rudder.setValue(MyJcontroller.rudder.valueProperty().getValue());
            throttle.setValue( MyJcontroller.throttle.valueProperty().getValue());
            MyJcontroller.moveJoystick();

            this.getChildren().add(ancp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
