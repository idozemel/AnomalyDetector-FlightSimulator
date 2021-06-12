package View;
import View.attList.MyAttList;
import View.btest.MyButtons;
import View.clocks.MyClocks;
import View.files.MyFiles;
import View.joystick.MyJoystick;
import ViewModel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
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

    @FXML
    MyClocks myClocks;


  //  DoubleBinding
    public ViewController(){  }

    void init(ViewModel vm){

        this.vm = vm;

        // my joystick
        myJoystick.aileron.bind(vm.aileron);
        myJoystick.elevators.bind(vm.elevators);
        myJoystick.rudder.bind(vm.rudder);
        myJoystick.throttle.bind(vm.throttle);



        // my buttons
        myButtons.myButtonsController.play=vm.play;
        myButtons.myButtonsController.pause=vm.pause;
        myButtons.myButtonsController.stop=vm.stop;
        myButtons.myButtonsController.forward=vm.forward;
        myButtons.myButtonsController.backward=vm.backward;
        myButtons.myButtonsController.fastbackward=vm.fastbackward;
        myButtons.myButtonsController.fastforward=vm.fastforward;
        myButtons.myButtonsController.timeSlider.valueProperty().bindBidirectional(vm.timeSlider);
        myButtons.myButtonsController.speed.valueProperty().bind(vm.speed.valueProperty());



        // my clocks
        myClocks.altitudeValue.bind(vm.altitudeValue);
        myClocks.directionValue.bind(vm.directionValue);
        myClocks.pitchValue.bind(vm.pitchValue);
        myClocks.rollValue.bind(vm.rollValue);
        myClocks.speedValue.bind(vm.speedValue);
        myClocks.yawValue.bind(vm.yawValue);

        //               - or that ..
        /*
        myClocks.myCcontroller.altitudeValue.valueProperty().bind(vm.altitudeValue);
        myClocks.myCcontroller.directionValue.valueProperty().bind(vm.directionValue);
        myClocks.myCcontroller.pitchValue.valueProperty().bind(vm.pitchValue);
        myClocks.myCcontroller.rollValue.valueProperty().bind(vm.rollValue);
        myClocks.myCcontroller.speedValue.valueProperty().bind(vm.speedValue);
        myClocks.myCcontroller.yawValue.valueProperty().bind(vm.yawValue);
        */


        // attList
        myAttList.MyAcontroller.attList.setItems(vm.attributeslist);
        //myFiles.myFController.timeSeries





        myButtons.setLayoutX(0);
        myButtons.setLayoutY(500);

        myJoystick.setLayoutX(640);
        myJoystick.setLayoutY(80);

        myAttList.setLayoutX(10);
        myAttList.setLayoutY(30);

        myClocks.setLayoutX(400);
        myClocks.setLayoutY(320);

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
