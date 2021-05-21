package View.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.css.SimpleStyleableDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

public class MyJoystickController {

    @FXML Canvas joystick;
    @FXML Slider throttle;
    @FXML Slider rudder;

    DoubleProperty aileron , elevators; // aileron -  X , elevator - Y

    double mx, my , jx,jy;; // midle x and y // x&y of joystick

    public MyJoystickController() {
       aileron = new SimpleDoubleProperty();
        elevators =  new SimpleDoubleProperty();
        jx = 0;
        jy = 0;
    }
    void moveJoystick () {
        GraphicsContext gc = joystick.getGraphicsContext2D();
        mx = joystick.getWidth() / 2;
        my = joystick.getHeight() / 2;
        gc.clearRect(0, 0, joystick.getWidth(), joystick.getHeight());
        gc.strokeOval(jx-50,jy-50,100,100);
        aileron.set(jx);
        elevators.set(jy);
    }
}
