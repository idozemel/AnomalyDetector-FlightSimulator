package View;

//import View.Buttoms.MyButtoms;

import View.btest.MyButtons;

import View.joystick.MyJoystick;
import ViewModel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.util.Observable;
import java.util.Observer;

public class ViewController extends Pane implements Observer {

    ViewModel vm;
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

        // my buttons
        vm.timeSlider.bind(myButtons.timeSlider);  // or myButtons.timeSlider.bind(vm.timeSlider);
        vm.speed.bind(myButtons.speed);
        vm.path.bind(myButtons.path);

/*

        AirSpeed.progressProperty().bind(viewModel.getAirSpeed());
        Yaw.progressProperty().bind(viewModel.getYaw());
        Roll.progressProperty().bind(viewModel.getRoll());
        Pitch.progressProperty().bind((viewModel.getPitch()));
        Heading.progressProperty().bind(viewModel.getHeading());
        Altimeter.progressProperty().bind(viewModel.getAltimeter());
*/




        myJoystick.setLayoutY(3);
        myJoystick.setLayoutY(55);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
