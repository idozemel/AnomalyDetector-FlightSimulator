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

        // my joystick
        MyJoystick.aileron.bind(vm.aileron);
        MyJoystick.elevators.bind(vm.elevators);
        MyJoystick.rudder.bind(vm.rudder);
        MyJoystick.throttle.bind(vm.throttle);

        //my buttoms
      //  MyButtoms.



      /*  MyJoystick.setLayoutX(10);
        MyJoystick.setLayoutY(10);*/
    }

}
