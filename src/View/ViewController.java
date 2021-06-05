package View;

//import View.Buttoms.MyButtoms;

import View.attList.MyAttList;
import View.btest.MyButtons;

import View.files.MyFiles;
import View.joystick.MyJoystick;
import ViewModel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.Observable;
import java.util.Observer;

public class ViewController extends BorderPane implements Observer {

    ViewModel vm;
    @FXML
    MyButtons myButtons;
    @FXML
    MyJoystick myJoystick;

    @FXML
    MyFiles myFiles;

    @FXML
    MyAttList myAttList;

    public ViewController(){  }

    void init(ViewModel vm){
        this.vm = vm;

        // my joystick


        myJoystick.aileron.bind(vm.aileron);
        myJoystick.elevators.bind(vm.elevators);
        myJoystick.rudder.bind(vm.rudder);
        myJoystick.throttle.bind(vm.throttle);
        // my buttons

        vm.timeSlider.bind(myButtons.timeSlider);  // or myButtons.timeSlider.bind(vm.timeSlider);
       // vm.speed.bind(myButtons.speed.getValue());
        vm.path.bind(myButtons.path);

        // the view is 1000 - 600

        myButtons.setLayoutX(0);
        myButtons.setLayoutY(500);

        myJoystick.setLayoutX(770);
        myJoystick.setLayoutY(40);

        myAttList.setLayoutX(10);
        myAttList.setLayoutY(30);

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
