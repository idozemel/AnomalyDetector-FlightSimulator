package View.btest;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class MyButtonsController {
    @FXML
    Button forward , backward, play, pause , stop ,fastforward, fastbackward;
    @FXML
    Slider timeSlider;
    @FXML
    ChoiceBox speed ;
    @FXML
    Label time;
    public StringProperty path;


    StringProperty FlightStatus;
    DoubleProperty forward_D;
    SimpleDoubleProperty fastforward_D;
    SimpleDoubleProperty backward_D;
    SimpleDoubleProperty fastbackward_D;
    double f = 0;


    public MyButtonsController() {
        super();
        path = new SimpleStringProperty();

        FlightStatus = new SimpleStringProperty();
        forward_D = new SimpleDoubleProperty();
        fastforward_D = new SimpleDoubleProperty();
        backward_D = new SimpleDoubleProperty();
        fastbackward_D = new SimpleDoubleProperty();
        time = new Label();


    }


    public void setSpeed(double x) {

        if ((x > 0.0 )&&(x < 2.0)){ speed.setValue(x);}
        else if(x >=2.1){ speed.setValue(2.0); }
        else
            speed.setValue(0.25);
    }



    public void PlayButton() {
        setSpeed(1.0);
    }

    public void PauseButton() {

    }

    public void StopButton(){

    }


    public void ForwardButton() {
        double x = (double) this.speed.getValue();
        setSpeed(x+0.25);
    }
    public void BackwardButton() {
        double x = (double) this.speed.getValue();
        if(x!=0) {
            setSpeed(x - 0.25);
        }
        else {}

    }
    public void FastForwardButton() {

    }
    public void FastBackwardButton(){

    }


}