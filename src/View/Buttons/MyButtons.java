package View.Buttons;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MyButtons extends BorderPane {
    public Button Open, forward, backward, play, pause , stop ,fastforward, fastbackward;
    public DoubleProperty speedSlider;
    public MyButtons() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            Pane bd = fxml.load(getClass().getResource("Buttoms.fxml").openStream());
            MyButtonsController MyBcontroller = fxml.getController();
            Open = MyBcontroller.Open;
            forward = MyBcontroller.forward;
            backward =MyBcontroller.backward;
            play = MyBcontroller.play;
            pause = MyBcontroller.pause;
            stop = MyBcontroller.stop;
            fastforward = MyBcontroller.fastforward;
            fastbackward = MyBcontroller.fastbackward;
            speedSlider = MyBcontroller.speedSlider.valueProperty();


            this.getChildren().add(bd);


        } catch (IOException e) { e.printStackTrace(); }
    }

}
