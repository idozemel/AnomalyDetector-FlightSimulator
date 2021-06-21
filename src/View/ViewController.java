package View;

import View.algGraph.MyAlgGraph;
import View.attributesList.MyAttList;
import View.buttons.MyButtons;
import View.clocks.MyClocks;
import View.files.MyFiles;
import View.graphs.MyGraphs;
import View.joystick.MyJoystick;
import ViewModel.ViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
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


    public IntegerProperty f1,f2;
    public XYChart.Series series1 , series2;


    public ViewController() {
    }

    void init(ViewModel vm) {

        this.vm = vm;


        // my joystick
        myJoystick.MyJcontroller.rudder.setMin(-1);
        myJoystick.MyJcontroller.rudder.setMax(1);
        myJoystick.MyJcontroller.rudder.setValue(0);
        myJoystick.MyJcontroller.throttle.setMin(-1);
        myJoystick.MyJcontroller.throttle.setMax(1);
        myJoystick.MyJcontroller.throttle.setValue(0);

        vm.throttle.addListener((obs, ov, nv) -> {
            myJoystick.MyJcontroller.throttle.setValue(nv.doubleValue());
        });
        vm.rudder.addListener((obs, ov, nv) -> {
            myJoystick.MyJcontroller.rudder.setValue(nv.doubleValue());
        });
        vm.aileron.addListener((obs, ov, nv) -> {
            myJoystick.MyJcontroller.joystick.setCenterY((nv.doubleValue()) * 40);
        });
        vm.elevators.addListener((obs, ov, nv) -> {
            myJoystick.MyJcontroller.joystick.setCenterX((nv.doubleValue()) * 40);
        });


        // my buttons
        myButtons.myButtonsController.play = vm.play;
        myButtons.myButtonsController.pause = vm.pause;
        myButtons.myButtonsController.stop = vm.stop;
        myButtons.myButtonsController.forward = vm.forward;
        myButtons.myButtonsController.backward = vm.backward;
        myButtons.myButtonsController.fastbackward = vm.fastbackward;
        myButtons.myButtonsController.fastforward = vm.fastforward;


        myButtons.trainTSlines.bind(vm.trainTSlines);
        myButtons.trainTSlines.addListener((obs, ov, nv) -> {
            myButtons.myButtonsController.timeSlider.setMax(vm.trainTSlines.get());
        });


        myButtons.myButtonsController.timeSlider.valueProperty().bindBidirectional(vm.timeSlider);
        myButtons.myButtonsController.d_speed.bind(vm.speed);



        // my clocks
        myClocks.altimeterValu.bind(vm.altimeterValue);
        myClocks.headingValue.bind(vm.headingValue);
        myClocks.pitchValue.bind(vm.pitchValue);
        myClocks.rollValue.bind(vm.rollValue);
        myClocks.speedValue.bind(vm.speedValue);
        myClocks.yawValue.bind(vm.yawValue);

        // attList
        myAttList.MyAcontroller.attList.setItems(vm.attributeslist);


        //Graphs
        f1 = new SimpleIntegerProperty();
        f2 = new SimpleIntegerProperty();

        vm.f1.bind(f1);
        vm.f2.bind(f2);

       // int index = f1.getValue();

        vm.f1ArryList.addListener(new ListChangeListener<Float>() {
            @Override
            public void onChanged(Change<? extends Float> c) {

                if(!series1.getData().isEmpty()){
                    series1.getData().clear();
                    series1.getData().add(new XYChart.Data("0",vm.f1ArryList.get(vm.time_step.get())));
                    if(!myGraphs.myGrpController.attributeGraph.getData().contains(series1)){
                        myGraphs.myGrpController.attributeGraph.getData().add(series1);
                    }
                }
            }
        });


        /*myGraphs.myGrpController.attributeGraph.dataProperty().bindBidirectional(vm.attg.dataProperty());
        myGraphs.myGrpController.correlativeGraph.dataProperty().bindBidirectional(vm.corg.dataProperty());*/


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
