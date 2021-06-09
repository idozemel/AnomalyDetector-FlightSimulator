package View.files;
import Commands.TimeSeries;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import java.io.File;

public class MyFilesController {


    @FXML
    public MenuItem csv;
    @FXML
    public MenuItem algo;

    public StringProperty CsvPath,AlgoPath;

    public TimeSeries timeSeries;

    public MyFilesController() {
        super();
        CsvPath = new SimpleStringProperty();
        AlgoPath = new SimpleStringProperty();

    }

    public void openCSVFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a Flight CSV File");

        fileChooser.setInitialDirectory(new File("./collection"));  // Default screen
        FileChooser.ExtensionFilter filterFiles = new FileChooser.ExtensionFilter("CSV Files","*.csv"); // filter the colection files
        fileChooser.getExtensionFilters().add(filterFiles);

        File chosen = fileChooser.showOpenDialog(null);
        if(chosen!=null)
            CsvPath.setValue("collection/"+chosen.getName());


        timeSeries = new TimeSeries(chosen.getName());

    }



    public void openAlgFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an Algorithm File");
        fileChooser.setInitialDirectory(new File("./src/Algorithms"));
        FileChooser.ExtensionFilter filterFiles = new FileChooser.ExtensionFilter("Algorithms Files","*.java");
        // צריך לבדוק כאשר הופכים אותם לפלאגינים מה קורה לסיומת
        fileChooser.getExtensionFilters().add(filterFiles);
        File chosen = fileChooser.showOpenDialog(null);
        if(chosen!=null)
            AlgoPath.setValue("src/Algorithms/"+chosen.getName());

    }



}
