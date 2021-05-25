package View;

//import View.Buttoms.MyButtoms;

import View.Buttons.MyButtons;
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
    MyButtons myButtons;
    @FXML
    MyJoystick myJoystick;

    public ViewController(){  }

    void init(ViewModel vm){
        this.vm = vm;

        // my joystick
        myJoystick.aileron.bind(vm.aileron);
        myJoystick.elevators.bind(vm.elevators);
        myJoystick.rudder.bind(vm.rudder);
        myJoystick.throttle.bind(vm.throttle);

        //vm.speedSlider.bind(myButtoms.speedSlider);

        //my buttoms
      //  MyButtoms.



      /*  MyJoystick.setLayoutX(10);
        MyJoystick.setLayoutY(10);*/
    }

}
