package View.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MyJoystick extends Canvas {

   public DoubleProperty aileron , elevators , rudder , throttle; // aileron -  X , elevator - Y

    public MyJoystick(){
        super();

        FXMLLoader fxml = new FXMLLoader();
        try {

            Canvas can = fxml.load(getClass().getResource("Joystick.fxml"));
            MyJoystickController MyJcontroller = fxml.getController();

            aileron=MyJcontroller.aileron;
            elevators = MyJcontroller.elevators;
            rudder = MyJcontroller.rudder.valueProperty();
            throttle=MyJcontroller.throttle.valueProperty();

        } catch (IOException e) { e.printStackTrace(); }


    }






    public void setViewModel(){
     /*   throttle.valueProperty().bind(this.viewModel.throttle);
        rudder.valueProperty().bind(this.viewModel.rudder);
        aileron.bind(this.viewModel.aileron);
        elevators.bind(this.viewModel.elevators);*/
    }


    void moveJoystick () {
     //   GraphicsContext gc = joystick.getGraphicsContext2D();
      /*  mx = joystick.getWidth() / 2;
        my = joystick.getHeight() / 2;
        gc.clearRect(0, 0, joystick.getWidth(), joystick.getHeight());
        gc.strokeOval(jx-50,jy-50,100,100);
        aileron.set(jx);
        elevators.set(jy);*/
    }

}
