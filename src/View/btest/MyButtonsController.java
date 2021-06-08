package View.btest;


import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class MyButtonsController implements Initializable {

/*
    @FXML
    public Button forward , backward, play, pause , stop ,fastforward, fastbackward;*/

    public Runnable forward , backward, play, pause , stop ,fastforward, fastbackward;

    @FXML
   public Slider timeSlider;
    @FXML
    public ChoiceBox speed ;
    @FXML
    public Label videoTime;
    public  DoubleProperty forward_D;
    public SimpleDoubleProperty fastforward_D;
    public SimpleDoubleProperty backward_D;
    public SimpleDoubleProperty fastbackward_D;




    public MyButtonsController() {
        super();
        forward_D = new SimpleDoubleProperty();
        fastforward_D = new SimpleDoubleProperty();
        backward_D = new SimpleDoubleProperty();
        fastbackward_D = new SimpleDoubleProperty();
        timeSlider = new Slider();
        timeSlider.setMin(0.0);
        videoTime = new Label();
    }





    public void PlayButton() {
        if(play!=null)
            play.run();
    }

    public void PauseButton() {
        if(pause!=null)
            pause.run();

    }

    public void StopButton(){
        if(stop!=null)
            stop.run();
    }


    public void ForwardButton() {
        if(forward!=null)
            forward.run();
    }

    public void BackwardButton() {
        if(backward!=null)
            backward.run();

    }
    public void FastForwardButton() {
        if(fastforward!=null)
            fastforward.run();
    }
    public void FastBackwardButton(){
        if(fastbackward!=null)
            fastbackward.run();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeSlider.valueProperty().addListener((obs,a,b)->{
            int x= (int) timeSlider.getValue();
            videoTime.setText(""+x/60/60+":"+x/60+":"+x%60);
        });


        videoTime.textProperty().addListener(((ob) -> {
           // timeSlider.setValue();
        }));

    }
}