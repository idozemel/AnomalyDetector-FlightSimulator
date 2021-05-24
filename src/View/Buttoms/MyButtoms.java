package View.Buttoms;

import View.joystick.MyJoystickController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class MyButtoms extends Pane {


    public Button Open, forward, backward, play, pause , stop ,fastforward, fastbackward;
    public Slider slider;

    public MyButtoms() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            BorderPane bd = fxml.load(getClass().getResource("Buttoms.fxml").openStream());
            MyButtomsController MyBcontroller = fxml.getController();
            Open = MyBcontroller.Open;
            forward = MyBcontroller.forward;
            backward =MyBcontroller.backward;
            play = MyBcontroller.play;
            pause = MyBcontroller.pause;
            stop = MyBcontroller.stop;
            fastforward = MyBcontroller.fastforward;
            fastbackward = MyBcontroller.fastbackward;
            slider = MyBcontroller.slider;

            this.getChildren().add(bd);


        } catch (IOException e) { e.printStackTrace(); }
    }


}
