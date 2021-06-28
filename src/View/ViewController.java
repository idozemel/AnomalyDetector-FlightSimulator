package View;


import View.attributesList.MyAttList;
import View.buttons.MyButtons;
import View.clocks.MyClocks;
import View.files.MyFiles;
import View.graphs.MyGraphs;
import View.joystick.MyJoystick;
import ViewModel.ViewModel;
import javafx.beans.property.*;
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

    public IntegerProperty index;
    public String name;
    public StringProperty name1;
    public StringProperty name2;
    public XYChart.Series<Number, Number> series;
    public XYChart.Series<Number, Number> series2;
    public BooleanProperty nameIsChanged;
    public FloatProperty valueLinear;
    public FloatProperty valueCor;
    public XYChart.Series<Number, Number> lineseries;
    public XYChart.Series<Number, Number> corseries;
    public XYChart.Series<Number, Number> zscoreseries;
    public FloatProperty ValueZS;

///----------------------------------------------------------------------------------


    public ViewController() {
        //Graphs
        index = new SimpleIntegerProperty(-1);
        name1 = new SimpleStringProperty();
        name2 = new SimpleStringProperty();
        series = new XYChart.Series<>();
        series2 = new XYChart.Series<>();
        valueLinear = new SimpleFloatProperty();
        valueCor = new SimpleFloatProperty();
        lineseries = new XYChart.Series<>();
        corseries = new XYChart.Series<>();

        /*zscoreseries = new XYChart.Series<>();
        ValueZS = new SimpleFloatProperty();
*/


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


        vm.index.bindBidirectional(index);
        //vm.name1VM.bind(name1);

        name1.addListener((obs, ov, nv) -> {
            vm.name1VM.setValue(nv);
        });
        vm.name2VM.bindBidirectional(name2);


        myAttList.MyAcontroller.attList.getItems().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {

                System.out.println("change at the list");

            }
        });
        myAttList.MyAcontroller.attList.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
            lineseries.getData().clear();
            corseries.getData().clear();

            name1.setValue(myAttList.MyAcontroller.attList.getSelectionModel().getSelectedItem());
            index.setValue(myAttList.MyAcontroller.attList.getSelectionModel().getSelectedIndex());
        });


        valueLinear.bind(vm.valueLinVM);
        valueCor.bind(vm.valueCorVM);


        vm.f1ArrayList.addListener(new ListChangeListener<Float>() {
            @Override
            public void onChanged(Change<? extends Float> c) {
                XYChart.Data dt = new XYChart.Data(vm.time_step.getValue(), valueLinear.getValue());
                lineseries.getData().add(dt);
                if ((!myGraphs.myGrpController.attributeGraph.getData().contains(lineseries))) {
                    ;
                    myGraphs.myGrpController.attributeGraph.getData().add(lineseries);
                }

            }
        });

        vm.f2ArrayList.addListener(new ListChangeListener<Float>() {
            @Override
            public void onChanged(Change<? extends Float> c) {
                XYChart.Data dt = new XYChart.Data(vm.time_step.getValue(), valueCor.getValue());
                corseries.getData().add(dt);
                if ((!myGraphs.myGrpController.correlativeGraph.getData().contains(corseries))) {
                    myGraphs.myGrpController.correlativeGraph.getData().add(corseries);
                }
            }
        });


        // files
        vm.trainPath.bind(myFiles.myFController.trainPath);
        vm.testPath.bind(myFiles.myFController.testPath);


        // set them in the window
        myButtons.setLayoutX(0);
        myButtons.setLayoutY(500);

        myJoystick.setLayoutX(730);
        myJoystick.setLayoutY(30);

        myAttList.setLayoutX(10);
        myAttList.setLayoutY(30);

        myClocks.setLayoutX(620);
        myClocks.setLayoutY(290);

        myGraphs.setLayoutX(200);
        myGraphs.setLayoutY(30);


    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
