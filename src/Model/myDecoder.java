package Model;

import java.beans.XMLDecoder;
import java.io.*;
import java.util.*;

public class myDecoder implements Serializable {
    public class PropertyList
    {
        String name;
        String type;
        String format;
        String node;

        public PropertyList(String name,String type, String format, String node) {
            this.name=name;
            this.type = type;
            this.format = format;
            this.node = node;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getNode() {
            return node;
        }

        public void setNode(String node) {
            this.node = node;
        }
        @Override
        public String toString(){
            return "Decoded : [1-" + type + " 2-" + format + " 3-" + node +"]";
        }
    }

    public myDecoder() { }

    Map<String,PropertyList> fgProperties = new HashMap<>();
    public void ShoterDecoder() {

        XMLDecoder d;

       /* Scanner s = null;
        try {
            s = new Scanner(new FileReader("anomaly_flight.csv"));


            String[] arr = s.nextLine().split(",");

            for (int i = 0; i < 42; i++) {
                fgProperties.getOrDefault(arr[i], null);
            }
            for (String name:fgProperties.keySet()) {
                System.out.println(name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/


        try {
            d = new XMLDecoder(new BufferedInputStream(new FileInputStream("playback_small.xml")));
            PropertyList result = (PropertyList) d.readObject();
            System.out.println(result.toString());
            d.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
