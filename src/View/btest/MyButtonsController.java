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
    Label videoTime;
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

    }


    public void setSpeed(String s) {
        double x = Double.parseDouble(s);
       // if ((x > 0 )&&(x < 2)){ speed.setText(s); }
       // else if(x >=2){ speed.setText("2"); }
      //  else
      //      speed.setText("0.25");
    }

    public void activationButton(){
        setSpeed("2");
    }


    /*public void openButton(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Flight CSV File");
        Stage stage = (Stage) Open.getScene().getWindow(); // bord
        path.setValue(fileChooser.showOpenDialog(stage).getAbsolutePath());
    }*/

    public void PlayButton() { setSpeed("1.0"); }
    public void PauseButton() { setSpeed("0.0"); }

    public void StopButton(){
        setSpeed("0.0");
        activationButton();
    }


    public void ForwardButton() {

    }
    public void BackwardButton() {
        //if(!speed.getText().equals("0")) {
          //  double x = Double.parseDouble(speed.getText()) + (-0.25);

          //  setSpeed(x);

        //}
    }
    public void FastForwardButton() {

    }
    public void FastBackwardButton(){

    }


}
