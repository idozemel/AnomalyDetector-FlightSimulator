package View.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;

public class MyJoystickController {

    @FXML
    Canvas joystick;
    @FXML
    public Slider throttle;
    @FXML
    public Slider rudder;

    public DoubleProperty aileron, elevators; // aileron -  X , elevator - Y
    public double mx, my, jx, jy; // midle x and y // x&y of joystick
/*
    aileron,1,-1
    elevator,1,-1
    rudder,1,-1
    throttle,1,-1
    */

    public MyJoystickController() {
        aileron = new SimpleDoubleProperty();
        elevators = new SimpleDoubleProperty();
        jx = 0;
        jy = 0;

        rudder=new Slider();
        throttle=new Slider();
        rudder.setMin(-1);
        rudder.setMax(1);
        throttle.setMin(-1);
        throttle.setMax(1);

    }

    void moveJoystick() {
        GraphicsContext gc = joystick.getGraphicsContext2D();
        mx = joystick.getWidth() / 2;
        my = joystick.getHeight() / 2;
        gc.clearRect(0, 0, joystick.getWidth(), joystick.getHeight());
        gc.strokeOval(aileron.doubleValue() + 50, elevators.doubleValue() + 50, 75, 75);
        aileron.set(jx);
        elevators.set(jy);
    }

}
