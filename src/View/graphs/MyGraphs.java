package View.graphs;

import javafx.fxml.FXMLLoader;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class MyGraphs extends AnchorPane {

    public MyGraphsController myGrpController;
    public AnchorPane ap = null;



    public MyGraphs() {

        super();

        try {
            FXMLLoader fxl = new FXMLLoader();
            ap = fxl.load(getClass().getResource("Graphs.fxml").openStream());
            myGrpController = fxl.getController();

            this.getChildren().add(ap);

        } catch (IOException e) {e.printStackTrace();}
    }




}
