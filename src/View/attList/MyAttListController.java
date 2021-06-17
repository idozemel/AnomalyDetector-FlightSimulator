package View.attList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MyAttListController{ // attList == attributes list

    @FXML public ListView attList;

    @FXML Button attXml;

    StringProperty attXmlPath;

    // List<String> myAList;
    public ObservableList list;

    public MyAttListController() {
        super();
       // myAList = new ArrayList<>();
        attList = new ListView<>();
        attXmlPath = new SimpleStringProperty();
        // LoadXmlData();

    }

    public File LoadXmlData(){
        /*
            load the date from XML to the list here.
         */
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an XML File");
        fileChooser.setInitialDirectory(new File("./collection"));
        FileChooser.ExtensionFilter filterFiles = new FileChooser.ExtensionFilter("XML Files","*.xml");
        fileChooser.getExtensionFilters().add(filterFiles);
        File chosen = fileChooser.showOpenDialog(null);

        if(chosen!=null)
            attXmlPath.setValue("collection/"+chosen.getName());

        return chosen;
    }



/*
    public void XMLdecoder(File file){

    XMLDecoder d = new XMLDecoder(
            new BufferedInputStream(
                    new FileInputStream(file)));
    Object result = d.readObject();
       d.close();*/
}
