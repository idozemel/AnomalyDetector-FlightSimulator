package View.algGraph;

import View.graphs.MyGraphsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyAlgGraph extends AnchorPane {

    public MyAlgGraphController myAlgGraphController;
    public AnchorPane ap = null;

    public MyAlgGraph() {

        super();

        try {
            FXMLLoader fxl = new FXMLLoader();
            ap = fxl.load(getClass().getResource("AlgGraph.fxml").openStream());
            myAlgGraphController = fxl.getController();


            this.getChildren().add(ap);

        } catch (IOException e) {e.printStackTrace();}
    }







}
