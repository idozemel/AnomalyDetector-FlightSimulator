package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


public class myDecoder {
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

    Map<String,Properties> fgProperties = new HashMap<>();
    public void ShoterDecoder() {
        XMLDecoder d;
        String stam;
        {
            try {
                d = new XMLDecoder(
                        new BufferedInputStream(
                                new FileInputStream("playback_small.xml")));
                //Properties result = (Properties) d.readObject();
                String result = (String) d.readObject();
                d.close();
                System.out.println(result);
                //return result;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        //return stam;
    }
}
