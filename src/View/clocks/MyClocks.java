package View.clocks;

import View.files.MyFilesController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyClocks {



    public MyClocks() {
        super();
        try {
            FXMLLoader fxl = new FXMLLoader();
            AnchorPane ap = fxl.load(getClass().getResource("Clocks.fxml").openStream());
            MyClocksController myCController = fxl.getController();
            //this.getChildren().add(ap); hh

        } catch (IOException e) { e.printStackTrace(); }


    }
}
