package Commands;

import java.util.*;
import java.util.List;
import static Commands.StatLib.avg;
import static Commands.StatLib.calcSD;


public class zScore implements TimeSeriesAnomalyDetector {

    public class ZscoreAnomaly {

        public final String description;
        public final  float threshZscore;

        public ZscoreAnomaly(String description , float threshZscore){
            this.description=description;
            this.threshZscore = threshZscore;
        }
    }


    public ZscoreAnomaly [] zArray;


    public float[] getcol(float[][] data, int column, int line) {

        float[] newArr = new float[line];

        for (int i = 0; i < line; i++) {
            newArr[i] = data[i][column];
        }
        return newArr;
    }

    @Override
    public void learnNormal(TimeSeries ts) {

        int NumOfFeat = ts.getFeatures_num();
        int LineNum = ts.Lines_num;
        this.zArray = new ZscoreAnomaly[NumOfFeat];

        float max=0;

        for (int j = 0; j < NumOfFeat; j++) { // columns

            float[] Zarr = new float[LineNum];

            for (int i = 0; i < LineNum; i++) { // lines

                float mean = avg(getcol(ts.data, j, i));
                float clcSD = calcSD(getcol(ts.data, j, i));


                Zarr[i] = (Math.abs(ts.data[i][j] - mean)) / clcSD;

                if (Zarr[i] > max)
                    max = Zarr[i];

            }

            zArray[j] = new ZscoreAnomaly(ts.name[j] ,max);

            max = 0;
        }
    }

    @Override
    public List<AnomalyReport> detect(TimeSeries ts) {

        int NumOfFeat = ts.getFeatures_num();
        int LineNum = ts.Lines_num;

        List<AnomalyReport> list = new ArrayList<>();

        for (int j = 0; j < NumOfFeat; j++) { // columns

            float max = zArray[j].threshZscore;

            for (int i = 0; i < LineNum; i++) { // lines
                float mean = avg(getcol(ts.data, j, i));
                float clcSD = calcSD(getcol(ts.data, j, i));

                float a = (Math.abs(ts.data[i][j] - mean)) / clcSD;

                if (a > max) {
                    list.add(new AnomalyReport(ts.name[j], i));
                }
            }
            //max=0;
        }
        return list;
    }


}
