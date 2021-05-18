package View.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;


// view
public class MyJoystick extends Canvas {

    VmJoystick viewModel;

    @FXML Canvas joystick;
    @FXML Slider throttle;
    @FXML Slider rudder;

    DoubleProperty aileron , elevators;

   //double mx, my , jx,jy;


    public void setViewModel(VmJoystick viewModel){

        throttle.valueProperty().bind(viewModel.throttle);
        rudder.valueProperty().bind(viewModel.rudder);
        aileron.bind(viewModel.aileron);
        elevators.bind(viewModel.elevators);

    }


    void moveJoystick (){
    //Aileron X & Elevators Y
        this.viewModel = viewModel;
        GraphicsContext gc = joystick.getGraphicsContext2D();
       // mx = joystick.getWidth()/2;
       // my = joystick.getHeight()/2;
        gc.clearRect(0,0,joystick.getWidth(),joystick.getHeight());
    }


}
