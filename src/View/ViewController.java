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
    public StringProperty Name1;
    public StringProperty Name2;
    public XYChart.Series series;
    public XYChart.Series series2;
    public BooleanProperty nameIsChanged;
    public FloatProperty Value;
    public XYChart.Series lineseries;
    public XYChart.Series zscoreseries;
    public FloatProperty ValueZS;


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
        index = new SimpleIntegerProperty();
        Name1 = new SimpleStringProperty();
        Name2 = new SimpleStringProperty();
        series = new XYChart.Series();
        series2 = new XYChart.Series();
        myGraphs.myGrpController.algorithmGraph.setAnimated(false);
        myGraphs.myGrpController.correlativeGraph.setCreateSymbols(false);
        myGraphs.myGrpController.attributeGraph.setCreateSymbols(false);
        myGraphs.myGrpController.algorithmGraph.setCreateSymbols(false);
        nameIsChanged = new SimpleBooleanProperty(false);
        Value = new SimpleFloatProperty();
        lineseries = new XYChart.Series();
        zscoreseries = new XYChart.Series();
        ValueZS = new SimpleFloatProperty();
        myGraphs.myGrpController.circle.setOpacity(0);

        vm.index.bindBidirectional(index);
        myAttList.MyAcontroller.attList.getItems().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {
                index.setValue(myAttList.MyAcontroller.attList.getSelectionModel().getSelectedIndex());
            }
        });


        Value.bind(vm.ValueVM);
        ValueZS.bind(vm.ValueZSVM);

        f1ArrayListListener();






        // files
        vm.trainPath.bind(myFiles.myFController.trainPath);
        vm.testPath.bind(myFiles.myFController.testPath);


        // set them in the window
        myButtons.setLayoutX(0);
        myButtons.setLayoutY(500);

        myJoystick.setLayoutX(670);
        myJoystick.setLayoutY(30);

        myAttList.setLayoutX(10);
        myAttList.setLayoutY(30);

        myClocks.setLayoutX(600);
        myClocks.setLayoutY(270);

        myGraphs.setLayoutX(200);
        myGraphs.setLayoutY(30);


    }
    public void f1ArrayListListener(){
        System.out.println("aaa");

/*

        vm.f1ArrayList.addListener(new ListChangeListener<Float>() {
            @Override
            public void onChanged(Change<? extends Float> c) {
                XYChart.Series aa = new XYChart.Series();

                aa.getData().add(2,3);
                myGraphs.myGrpController.attributeGraph.getData().add(aa);
                System.out.println("bllalala");
            }


            */
/*   public void onChanged(Change<? extends Float> change) {

                if(vm.time_step.get() == 0){
                    if((Name2.getValue() != null) || (Name2.getValue() != "-1")){
                        if(!series2.getData().isEmpty()){
                            series2.getData().clear();
                            if(vm.f2ArrayList.size() > 0){
                                series2.getData().add(new XYChart.Data(0, vm.f2ArrayList.get(vm.time_step.get())));
                                if(!myGraphs.myGrpController.correlativeGraph.getData().contains(series2)) {
                                    myGraphs.myGrpController.correlativeGraph.getData().add(series2);
                                }
                            }
                        }
                    }
                    if(!series.getData().isEmpty()){
                        series.getData().clear();
                        series.getData().add(new XYChart.Data(0, vm.f1ArrayList.get(vm.time_step.get())));
                        //series.getData().add(new XYChart.Data("0", 0));
                        if(! myGraphs.myGrpController.attributeGraph.getData().contains(series)){
                            myGraphs.myGrpController.attributeGraph.getData().add(series);
                        }

                    }

                }
                else{

                    int t = vm.time_step.getValue();
                    series.getData().add(new XYChart.Data((t), vm.f1ArrayList.get(vm.f1ArrayList.size()-1)));
                    if((!myGraphs.myGrpController.attributeGraph.getData().contains(series)) && (myGraphs.myGrpController.attributeGraph.getData() != null)){
                        myGraphs.myGrpController.attributeGraph.getData().add(series);
                    }


                    if((Name2.getValue() != null) || (Name2.getValue() != "-1")){
                        int t2 = vm.time_step.getValue();
                        //String place2 = viewmodel.timeStep.getValue().toString();
                        int i = vm.f2ArrayList.size()-1;
                        float index2 = -2;
                        if(i >= 0){
                            index2 = vm.f2ArrayList.get(i);
                            series2.getData().add((new XYChart.Data((t2),index2)));
                        }
                        if((!myGraphs.myGrpController.correlativeGraph.getData().contains(series2))  && (myGraphs.myGrpController.correlativeGraph.getData() != null)){
                            myGraphs.myGrpController.correlativeGraph.getData().add(series2);
                        }
                    }
                    else{
                        series2.getData().clear();
                        myGraphs.myGrpController.correlativeGraph.getData().clear();
                        if(!myGraphs.myGrpController.correlativeGraph.getData().contains(series2)){
                            myGraphs.myGrpController.correlativeGraph.getData().add(series2);
                        }
                    }
                    System.out.println("value changed");
                }
            }*//*



        });
*/

    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
