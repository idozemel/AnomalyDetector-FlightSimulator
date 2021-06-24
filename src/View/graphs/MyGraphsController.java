package View.graphs;

;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;


public class MyGraphsController  {

    public Runnable onClick;

    @FXML
    public LineChart<Number,Number> attributeGraph;
    @FXML
    public LineChart<Number,Number> correlativeGraph;

    @FXML
    public LineChart<Number,Number> algorithmGraph;

    @FXML
    public Circle circle;



    public MyGraphsController() {
        super();

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        attributeGraph = new LineChart<Number, Number>(xAxis, yAxis);
        // chart1.setTitle("");

        final NumberAxis xAxis2 = new NumberAxis();
        final NumberAxis yAxis2 = new NumberAxis();
        correlativeGraph = new LineChart<Number, Number>(xAxis2, yAxis2);
        // chart2.setTitle("");

        final NumberAxis xAxis3 = new NumberAxis();
        final NumberAxis yAxis3 = new NumberAxis();
        algorithmGraph = new LineChart<Number, Number>(xAxis3, yAxis3);


    }




    public LineChart getFchart() {
        return attributeGraph;
    }

    public void setFchart(LineChart fchart) {
        attributeGraph = fchart;
    }
}
