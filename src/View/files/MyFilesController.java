package View.files;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MyFilesController {


    @FXML
    MenuItem csv;
    @FXML
    MenuItem algo;

    StringProperty CsvPath,AlgoPath;

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
