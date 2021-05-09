package View;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;


public class MyButtoms extends Pane {

    public Button Open, forward, backward, play, pause , stop ,fastforward, fastbackward;
    public Slider slider;

    //@FXML
    public List<Node> set(){
        List<Node> ndlst = new ArrayList<>();

        play = new Button("play");
        play.setLayoutX(25);
        play.setLayoutY(320);
        play.setPrefSize(60,30);
        ndlst.add(play);

        Open = new Button("Open");
        Open.setLayoutX(25);
        Open.setLayoutY(320);
        Open.setPrefSize(60,30);
        ndlst.add(Open);

        forward = new Button("forward");
        forward.setLayoutX(25);
        forward.setLayoutY(320);
        forward.setPrefSize(60,30);
        ndlst.add(forward);

        backward = new Button("backward");
        backward.setLayoutX(25);
        backward.setLayoutY(320);
        backward.setPrefSize(60,30);
        ndlst.add(backward);

        pause = new Button("pause");
        pause.setLayoutX(25);
        pause.setLayoutY(320);
        pause.setPrefSize(60,30);
        ndlst.add(pause);

        stop = new Button("stop");
        stop.setLayoutX(25);
        stop.setLayoutY(320);
        stop.setPrefSize(60,30);
        ndlst.add(stop);

        fastforward = new Button("fastforward");
        fastforward.setLayoutX(25);
        fastforward.setLayoutY(320);
        fastforward.setPrefSize(60,30);
        ndlst.add(fastforward);

        fastbackward = new Button("fastbackward");
        fastbackward.setLayoutX(25);
        fastbackward.setLayoutY(320);
        fastbackward.setPrefSize(60,30);
        ndlst.add(fastbackward);


        slider = new Slider();


        return ndlst;
    }


}
