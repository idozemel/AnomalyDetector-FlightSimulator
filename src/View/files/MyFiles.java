package View.files;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyFiles extends AnchorPane {

    public MenuItem algo;
    public StringProperty algopath;
    public MenuItem csv;
    public StringProperty trainpath;
    public StringProperty testPath;
    public MyFilesController myFController;


    public MyFiles() {
        super();
        try {
            FXMLLoader fxl = new FXMLLoader();
            AnchorPane ap = fxl.load(getClass().getResource("Files.fxml").openStream());
            myFController = fxl.getController();
            algo = myFController.algo;
            algopath = myFController.algoPath;
            trainpath = myFController.trainPath;
            testPath = myFController.testPath;
            this.getChildren().add(ap);

        } catch (IOException e) { e.printStackTrace(); }


    }
}
