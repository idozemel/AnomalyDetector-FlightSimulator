package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Model extends Observable {

    public class Properties
    {
        String type;
        String format;
        String node;

        public Properties(String type, String format, String node) {
            this.type = type;
            this.format = format;
            this.node = node;
        }
    }
    Map<String,Properties> fgProperties = new HashMap<>();
    XMLDecoder d;

    {
        try {
            d = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream("Test.xml")));

            for (int i = 0; i < 42; i++)
            {
                fgProperties.getOrDefault(d.readObject(),new Properties()) = d.readObject();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
