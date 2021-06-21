package View.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyJoystick extends AnchorPane {
    /*
       public DoubleProperty rudder , throttle; // aileron -  X , elevator - Y
     */
    public MyJoystickController MyJcontroller;
    public AnchorPane ancp = null;

    public MyJoystick() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            ancp = fxml.load(getClass().getResource("Joystick.fxml").openStream());
            MyJcontroller = fxml.getController();


            /*rudder = new SimpleDoubleProperty();
            throttle = new SimpleDoubleProperty();

            //
          //  aileron.setValue(Double.parseDouble(MyJcontroller.aileron.getText()));
           // elevators.setValue(Double.parseDouble(MyJcontroller.elevators.getText()));
            rudder.setValue(MyJcontroller.rudder.valueProperty().getValue());
            throttle.setValue( MyJcontroller.throttle.valueProperty().getValue());*/

            this.getChildren().add(ancp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
