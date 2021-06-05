package View.btest;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class MyButtons extends AnchorPane {

    // --- old --------------
    public Button forward, backward, play, pause , stop ,fastforward, fastbackward;
    public ChoiceBox speed;
    public DoubleProperty timeSlider , time;
    // --- old --------------

    MyButtonsController myButtonsController;

    public MyButtons() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            AnchorPane ap = fxml.load(getClass().getResource("Buttons.fxml").openStream());
            myButtonsController = fxml.getController();

            this.forward = myButtonsController.forward;
            this.backward = myButtonsController.backward;
            this.play = myButtonsController.play;
            this.pause  = myButtonsController.pause;
            this.stop  = myButtonsController.stop;
            this.fastforward = myButtonsController.fastforward;
            this.fastbackward  = myButtonsController.fastbackward;
            this.speed = myButtonsController.speed;
            ObservableList<Double> s  = FXCollections.observableArrayList(0.0,0.25,0.5,0.75,1.0,1.25,1.5,1.75,2.0);
            speed.setItems(s);
            speed.setValue(1.0);
            timeSlider=new SimpleDoubleProperty();
            timeSlider.setValue(myButtonsController.timeSlider.getValue());
            time=new SimpleDoubleProperty();
           this.getChildren().add(ap);

        } catch (IOException e) {e.printStackTrace();}
    }




}