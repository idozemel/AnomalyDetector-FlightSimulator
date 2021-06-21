package View.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;

public class MyJoystickController {
    @FXML
    public Circle circle;
    @FXML
    public Circle joystick;
    @FXML
    public Slider throttle;
    @FXML
    public Slider rudder;


/*
    aileron,1,-1
    elevator,1,-1
    rudder,1,-1
    throttle,1,-1
    */

    public MyJoystickController() {
        rudder=new Slider();
        throttle=new Slider();
        circle = new Circle();
        joystick = new Circle();
    }


 /*   void moveJoystick() {
        GraphicsContext gc = joystick.getGraphicsContext2D();
        mx = joystick.getWidth() / 2;
        my = joystick.getHeight() / 2;
        gc.clearRect(0, 0, joystick.getWidth(), joystick.getHeight());
        gc.strokeOval(Double.parseDouble(aileron.getText()) + 50, Double.parseDouble(elevators.getText()) + 50, 75, 75);
        aileron.setText(String.valueOf(jx));
        elevators.setText(String.valueOf(jy));
    }*/

}
