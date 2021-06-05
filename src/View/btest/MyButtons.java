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

    public Button forward, backward, play, pause , stop ,fastforward, fastbackward;
    public ChoiceBox speed;
    public DoubleProperty timeSlider;
    public StringProperty path;

    public MyButtons() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            AnchorPane ap = fxml.load(getClass().getResource("Buttons.fxml").openStream());
            MyButtonsController MyBcontroller = fxml.getController();

            this.forward = MyBcontroller.forward;
            this.backward = MyBcontroller.backward;
            this.play = MyBcontroller.play;
            this.pause  = MyBcontroller.pause;
            this.stop  = MyBcontroller.stop;
            this.fastforward = MyBcontroller.fastforward;
            this.fastbackward  = MyBcontroller.fastbackward;
            this.speed = MyBcontroller.speed;
            ObservableList<Number> s  = FXCollections.observableArrayList(0.5,1.0,1.25,1.5,2.0);
            speed.setItems(s);
            speed.setValue(1.0);
            timeSlider=new SimpleDoubleProperty();
            path=new SimpleStringProperty();
            timeSlider.setValue(MyBcontroller.timeSlider.getValue());
            path.setValue(MyBcontroller.path.getValue());

            this.getChildren().add(ap);

        } catch (IOException e) {e.printStackTrace();}
    }




}