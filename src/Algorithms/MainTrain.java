package Algorithms;

import Commands.AnomalyReport;
import Commands.TimeSeries;

import java.util.ArrayList;

public class MainTrain {


	public static void main(String[] args) {

		zScore z = new zScore();
		TimeSeries train = new TimeSeries("reg_flight.csv");
		TimeSeries test = new TimeSeries("anomaly_flight.csv");

		z.learnNormal(train);
		ArrayList<AnomalyReport> arr = (ArrayList<AnomalyReport>) z.detect(test);


		for(AnomalyReport a : arr){
			System.out.println(a.description +" "+  a.timeStep);
		}

	}

}
