package View.buttons;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;


public class MyButtonsController implements Initializable {


    public Runnable forward, backward, play, pause, stop, fastforward, fastbackward;

    @FXML
    public Slider timeSlider;
    @FXML
    public ChoiceBox<Float> speed;
    @FXML
    public Label videoTime;
    public FloatProperty d_speed;
    public DoubleProperty forward_D;
    public SimpleDoubleProperty fastforward_D;
    public SimpleDoubleProperty backward_D;
    public SimpleDoubleProperty fastbackward_D;


    public MyButtonsController() {
        super();
        forward_D = new SimpleDoubleProperty();
        fastforward_D = new SimpleDoubleProperty();
        backward_D = new SimpleDoubleProperty();
        fastbackward_D = new SimpleDoubleProperty();
        d_speed = new SimpleFloatProperty();
        timeSlider = new Slider();
        timeSlider.setMin(0);
        videoTime = new Label();
    }
    public void getSpeedChoise(){
        if( speed.getValue().equals("0.5")){
            d_speed.setValue(0.5);
        }else if(speed.getValue().equals("1.0")){
            d_speed.setValue(1.0);
        }else if(speed.getValue().equals("1.5")){
            d_speed.setValue(1.5);
        }else if(speed.getValue().equals("2.0")){
            d_speed.setValue(2.0);
        }
    }

    public void PlayButton() {
        if (play != null)
            play.run();
    }

    public void PauseButton() {
        if (pause != null)
            pause.run();

    }

    public void StopButton() {
        if (stop != null)
            stop.run();
    }


    public void ForwardButton() {
        if (forward != null)
            forward.run();
    }

    public void BackwardButton() {
        if (backward != null)
            backward.run();

    }

    public void FastForwardButton() {
        if (fastforward != null)
            fastforward.run();
    }

    public void FastBackwardButton() {
        if (fastbackward != null)
            fastbackward.run();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeSlider.valueProperty().addListener((obs, ov, nv) -> {
            int x = (int) timeSlider.getValue();
           videoTime.setText("" + x / 60 / 60 + ":" + x / 60 + ":" + x % 60);
        });


    }
}