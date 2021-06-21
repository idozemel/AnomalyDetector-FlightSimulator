package View.buttons;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class MyButtons extends AnchorPane {


    public ChoiceBox<Float> speed;
    public DoubleProperty timeSlider, videoTime;
    public IntegerProperty trainTSlines, testTSlines;


    public MyButtonsController myButtonsController;

    public MyButtons() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        AnchorPane ap = null;
        try {
            ap = fxml.load(getClass().getResource("Buttons.fxml").openStream());
            myButtonsController = fxml.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (ap != null) {
            this.speed = myButtonsController.speed;
            ObservableList<Float> s = FXCollections.observableArrayList(0.5F, 1.0F, 1.5F, 2.0F);
            speed.setItems(s);
            speed.setValue(1.0F);
            trainTSlines = new SimpleIntegerProperty();
            testTSlines = new SimpleIntegerProperty();
            timeSlider = new SimpleDoubleProperty();
            timeSlider.setValue(myButtonsController.timeSlider.getValue());
            videoTime = new SimpleDoubleProperty();
            this.getChildren().add(ap);
        } else {
            myButtonsController = null;
        }
    }


}