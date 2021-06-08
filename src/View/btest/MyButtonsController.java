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
    ChoiceBox speed ;
    @FXML
    Label videoTime;
    DoubleProperty forward_D;
    SimpleDoubleProperty fastforward_D;
    SimpleDoubleProperty backward_D;
    SimpleDoubleProperty fastbackward_D;




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


    public void setSpeed(double x) {

        if ((x > 0.0 )&&(x < 2.0)){ speed.setValue(x);}
        else if(x >=2.1){ speed.setValue(2.0); }
        else
            speed.setValue(0.25);
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

        /*//double x = (double) this.speed.getValue();
        int x= (int) timeSlider.getValue();
        //int y = Integer.parseInt(videoTime.textProperty().getValue());
        videoTime.setText(""+x/60/60+":"+(x+15)/60+":"+x%60);*/
        if(forward!=null)
            forward.run();
    }




    public void BackwardButton() {
        /*double x = (double) this.speed.getValue();
        if(x!=0) {
            setSpeed(x - 0.25);
        }
        else {}*/

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