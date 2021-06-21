package View.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyJoystick extends AnchorPane {

    public MyJoystickController MyJcontroller;
    public AnchorPane ancp = null;

    public MyJoystick() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            ancp = fxml.load(getClass().getResource("Joystick.fxml").openStream());
            MyJcontroller = fxml.getController();

            this.getChildren().add(ancp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
