package View.graphs;

;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;


public class MyGraphsController implements Initializable {


    @FXML
    public LineChart<String,Number> attributeGraph;
    @FXML
    public LineChart<String,Number> correlativeGraph;


    public MyGraphsController() {
        super();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
/*

        XYChart.Series series = new XYChart.Series();

        series.getData().add(new XYChart.Data("1",23));
        series.getData().add(new XYChart.Data("2",33));
        attributeGraph.getData().addAll(series);

*/


    }
}
