package View;

import View.algGraph.MyAlgGraph;
import View.attributesList.MyAttList;
import View.buttons.MyButtons;
import View.clocks.MyClocks;
import View.files.MyFiles;
import View.graphs.MyGraphs;
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
    @FXML
    MyGraphs myGraphs;
    @FXML
    MyAlgGraph myAlgGraph;


    public ViewController() {
    }

    void init(ViewModel vm) {

        this.vm = vm;

        // my joystick
        /*
        myJoystick.aileron.bind(vm.aileron);
        myJoystick.elevators.bind(vm.elevators);
        myJoystick.rudder.bind(vm.rudder);
        myJoystick.throttle.bind(vm.throttle);
        */
        vm.joyyChange.addListener((obs,ov,nv)->{
            myJoystick.MyJcontroller.aileron.setValue(vm.aileron.getValue());
            myJoystick.MyJcontroller.elevators.setValue(vm.elevators.getValue());
            myJoystick.MyJcontroller.rudder.setValue(vm.rudder.getValue());
            myJoystick.MyJcontroller.throttle.setValue(vm.throttle.getValue());

        });

        /*

        vm.aileron.addListener((obs,ov,nv)->{ myJoystick.MyJcontroller.aileron.setValue(nv); });
        vm.elevators.addListener((obs,ov,nv)->{ myJoystick.MyJcontroller.elevators.setValue(nv);});
        vm.rudder.addListener((obs,ov,nv)->{ myJoystick.MyJcontroller.rudder.setValue(nv.doubleValue());});
        vm.throttle.addListener((obs,ov,nv)->{ myJoystick.MyJcontroller.throttle.setValue(nv.doubleValue());});
*/





        // my buttons
        myButtons.myButtonsController.play = vm.play;
        myButtons.myButtonsController.pause = vm.pause;
        myButtons.myButtonsController.stop = vm.stop;
        myButtons.myButtonsController.forward = vm.forward;
        myButtons.myButtonsController.backward = vm.backward;
        myButtons.myButtonsController.fastbackward = vm.fastbackward;
        myButtons.myButtonsController.fastforward = vm.fastforward;
        myButtons.myButtonsController.timeSlider.valueProperty().bindBidirectional(vm.timeSlider);
        myButtons.myButtonsController.speed.valueProperty().bind(vm.speed.valueProperty());



        // my clocks
        myClocks.altimeterValu.bind(vm.altimeterValue);
        myClocks.headingValue.bind(vm.headingValue);
        myClocks.pitchValue.bind(vm.pitchValue);
        myClocks.rollValue.bind(vm.rollValue);
        myClocks.speedValue.bind(vm.speedValue);
        myClocks.yawValue.bind(vm.yawValue);

        // attList
        myAttList.MyAcontroller.attList.setItems(vm.attributeslist);


        // files
        vm.trainPath.bind(myFiles.myFController.trainPath);
        vm.testPath.bind(myFiles.myFController.testPath);


        // set them in the window
        myButtons.setLayoutX(0);
        myButtons.setLayoutY(500);

        myJoystick.setLayoutX(640);
        myJoystick.setLayoutY(30);

        myAttList.setLayoutX(10);
        myAttList.setLayoutY(30);

        myClocks.setLayoutX(500);
        myClocks.setLayoutY(270);

        myGraphs.setLayoutX(200);
        myGraphs.setLayoutY(30);

        myAlgGraph.setLayoutX(200);
        myAlgGraph.setLayoutY(250);

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
