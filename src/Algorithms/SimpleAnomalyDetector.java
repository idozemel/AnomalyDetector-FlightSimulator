package Algorithms;


// zehava liviyev ~ 322759366



import Commands.*;

import java.util.*;

import static Commands.StatLib.*;

public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {

	public static float corOffset= (float) 0.9;
	public List<CorrelatedFeatures> corlist ;

	@Override
	public void learnNormal(TimeSeries ts) {  // do person ...

		if (corlist==null)
			corlist=new ArrayList<CorrelatedFeatures>();

		float corolatzia=0;
		int temp =0;
		Point[] pArr = new Point[ts.getLines_num()];

		float co = 0;

		for(int i=0 ; i<ts.getFeatures_num();i++) {

			for (int j = i; j < ts.getFeatures_num(); j++) {     // Find the corolatzia

				if(j!=i){

					co =Math.abs(pearson(ts.Get(ts.data, i), ts.Get(ts.data, j)));
					if (co > corolatzia) {
						corolatzia=co;
						temp = j;

					}
				}
			}


			if(corolatzia > corOffset){

				for (int a = 0 ;a<ts.getLines_num();a++){                     // point arr ;
				pArr[a ]=new Point(ts.data[a][i],ts.data[a][temp]);
				}

				Line l = linear_reg(pArr);

				float maxDev = 0;
				for (Point p:pArr) {           // deviation between point p and the line
					float dt=dev(p,l);
					if(dt>maxDev)
						maxDev=dt;
				}

				corlist.add(new CorrelatedFeatures(ts.name[i],ts.name[temp],corolatzia,l, maxDev));

			}
			corolatzia=0;
		}
	}

	public boolean isAnomalous(float x, float y, CorrelatedFeatures c){
		return (Math.abs((y- c.lin_reg.f(x))) > c.threshold);
	}

	@Override
	public List<AnomalyReport> detect(TimeSeries ts) {
		List<AnomalyReport> list = new ArrayList<>();
		int temp1=0, temp2=0;

		for (CorrelatedFeatures ccc:corlist ){


			String fit1 = ccc.feature1;
			String fit2 = ccc.feature2;

			for (int z=0;z<ts.getFeatures_num();z++){     // temp1-2   - column
				if (ts.name[z].equals(fit1)){
					temp1=z;
				}else if (ts.name[z].equals(fit2)){
					temp2=z;
				}
			}

			float[] X = ts.Get(ts.data,temp1); // get the column of the index temp1

			float[] Y = ts.Get(ts.data,temp2); // // get the column of the index temp2


			for(int i =0;i< X.length;i++){

				Point P = new Point(X[i],Y[i]);
				float dev = dev(P, ccc.lin_reg);

				if (dev> ccc.threshold+0.1){
					String description = fit1 + "-" + fit2;
					list.add(new AnomalyReport(description , i+1));  // or i+1
				}
			}
		}

		return list;
	}
	
	public List<CorrelatedFeatures> getNormalModel(){
		return corlist;
	}
}
