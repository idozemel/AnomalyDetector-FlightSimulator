package View.files;
import Algorithms.TimeSeries;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import java.io.File;

public class MyFilesController {


    @FXML
    public MenuItem train;
    @FXML
    public MenuItem test;

    @FXML
    public MenuItem algo;

    public StringProperty trainPath,algoPath,testPath;


    public MyFilesController() {
        super();
        trainPath = new SimpleStringProperty();
        testPath = new SimpleStringProperty();
        algoPath = new SimpleStringProperty();

    }

    public void openTrainFile() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a Flight CSV File");

        fileChooser.setInitialDirectory(new File("./collection"));  // Default screen

        FileChooser.ExtensionFilter filterFiles = new FileChooser.ExtensionFilter("CSV Files","*.csv"); // filter the colection files
        fileChooser.getExtensionFilters().add(filterFiles);

        File chosen = fileChooser.showOpenDialog(null);

        if(chosen!=null){

            String ssss = chosen.getAbsolutePath();
            trainPath.setValue(ssss);
            System.out.println(ssss);

        }
    }
    public void openTestFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a Flight CSV File");

        fileChooser.setInitialDirectory(new File("./collection"));  // Default screen

        FileChooser.ExtensionFilter filterFiles = new FileChooser.ExtensionFilter("CSV Files","*.csv"); // filter the colection files
        fileChooser.getExtensionFilters().add(filterFiles);

        File chosen = fileChooser.showOpenDialog(null);

        if(chosen!=null){
            String ssss = chosen.getAbsolutePath();
            testPath.setValue(ssss);
        }
    }


    public void openAlgFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an Algorithm File");
        fileChooser.setInitialDirectory(new File("./Algorithms"));
        FileChooser.ExtensionFilter filterFiles = new FileChooser.ExtensionFilter("Algorithms Files","*.java");
        // ׳¦׳¨׳™׳� ׳�׳‘׳“׳•׳§ ׳›׳�׳©׳¨ ׳”׳•׳₪׳›׳™׳� ׳�׳•׳×׳� ׳�׳₪׳�׳�׳’׳™׳ ׳™׳� ׳�׳” ׳§׳•׳¨׳” ׳�׳¡׳™׳•׳�׳×
        fileChooser.getExtensionFilters().add(filterFiles);
        File chosen = fileChooser.showOpenDialog(null);
        if(chosen!=null)
            algoPath.setValue("src/Algorithms/"+chosen.getName());

    }



}
