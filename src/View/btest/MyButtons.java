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

import javax.swing.*;
import java.io.IOException;


public class MyButtons extends AnchorPane {

    // --- old --------------
    // public Button forward, backward, play, pause , stop ,fastforward, fastbackward;
    public ChoiceBox<Float> speed;
    public DoubleProperty timeSlider , videoTime;
    // --- old --------------

    public MyButtonsController myButtonsController;

    public MyButtons() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        AnchorPane ap=null;
        try {
            ap = fxml.load(getClass().getResource("Buttons.fxml").openStream());
            myButtonsController = fxml.getController();
        } catch (IOException e) {e.printStackTrace();}

        if(ap!=null){
             /*  this.forward = myButtonsController.forward;
            this.backward = myButtonsController.backward;
            this.play = myButtonsController.play;
            this.pause  = myButtonsController.pause;
            this.stop  = myButtonsController.stop;
            this.fastforward = myButtonsController.fastforward;
            this.fastbackward  = myButtonsController.fastbackward;*/
            this.speed = myButtonsController.speed;
            ObservableList<Float> s  =FXCollections.observableArrayList(0.0F,0.25F,0.5F,0.75F,1.0F,1.25F,1.5F,1.75F,2.0F);
            speed.setItems(s);
            speed.setValue(1.0F);
            timeSlider=new SimpleDoubleProperty();
            timeSlider.setValue(myButtonsController.timeSlider.getValue());
            videoTime=new SimpleDoubleProperty();
            this.getChildren().add(ap);
        }else {
            myButtonsController=null;
        }
    }




}