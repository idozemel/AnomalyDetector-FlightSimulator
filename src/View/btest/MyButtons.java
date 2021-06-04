package View.btest;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class MyButtons extends AnchorPane {

    public Button forward, backward, play, pause , stop ,fastforward, fastbackward;
    public DoubleProperty speed;
    public DoubleProperty timeSlider;
    public StringProperty path;

    public MyButtons() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            AnchorPane ap = fxml.load(getClass().getResource("Buttons.fxml").openStream());
            MyButtonsController MyBcontroller = fxml.getController();
            speed=new SimpleDoubleProperty();
            timeSlider=new SimpleDoubleProperty();
            path=new SimpleStringProperty();
          // speed.setValue(Double.parseDouble(MyBcontroller.speed.getText()));
           timeSlider.setValue(MyBcontroller.timeSlider.getValue());
           path.setValue(MyBcontroller.path.getValue());

            this.getChildren().add(ap);

        } catch (IOException e) {e.printStackTrace();}
    }




}
