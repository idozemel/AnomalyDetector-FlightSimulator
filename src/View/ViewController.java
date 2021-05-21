package View;

import View.Buttoms.MyButtoms;
import View.joystick.MyJoystick;
import ViewModel.ViewModel;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

import java.util.Observable;

public class ViewController extends Observable {

    ViewModel vm;

    @FXML
    Canvas TheCanvas;
    @FXML
    MyButtoms myButtoms;
    @FXML
    MyJoystick MyJoystick;

    public ViewController(){  }

    void init(ViewModel vm){
        this.vm = vm;
        vm.aileron.bind(MyJoystick.aileron);
        vm.elevators.bind(MyJoystick.elevators);
        vm.rudder.bind(MyJoystick.rudder);
        vm.throttle.bind(MyJoystick.throttle);

        MyJoystick.setLayoutX(30);
        MyJoystick.setLayoutY(30);
    }

}
