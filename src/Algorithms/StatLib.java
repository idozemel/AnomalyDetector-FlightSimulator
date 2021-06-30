package Algorithms;


public class StatLib {

	// simple average
	public static float avg(float[] x){
		float count =0;
		for(int i=0 ; i<x.length ; i++) {
			count += x[i];
		}
		return (count/x.length);

	}


	// Standard deviation - ׳¡׳˜׳™׳™׳× ׳×׳§׳�
	public static float calcSD(float[] arr)
	{
		float standardDeviation = 0;
		float mean = avg(arr);

		for(float num: arr) {
			standardDeviation += Math.pow(num - mean, 2);
		}

		return (float) Math.sqrt(standardDeviation/arr.length);
	}

	// returns the variance of X and Y
	public static float var(float[] x){
		float avg = avg(x);
		float count=0;
		for(int i=0 ; i<x.length ; i++) {
			count = count + (x[i]*x[i]) ;
		}
		count = count/x.length;
		count=count-avg*avg;
		return count;
	}


	// returns the covariance of X and Y   ׳©׳•׳ ׳•׳× ׳�׳©׳•׳×׳₪׳×
	public static float cov(float[] x, float[] y){
		float avgX = avg(x);
		float avgY = avg(y);
		float count = 0;

		for( int i = 0 ; i<x.length ; i++)
		{
			count += ((x[i]-avgX)*(y[i]-avgY));
		}
		return (count/x.length);



	}


	// returns the Pearson correlation coefficient of X and Y
	public static float pearson(float[] x, float[] y) {
		float cov = cov(x,y);
		float Sx = (float)Math.sqrt(var(x));
		float Sy = (float)Math.sqrt(var(y));

		cov = cov /(Sx * Sy);
		return cov;


	}

	// performs a linear regression and returns the line equation
	public static Line linear_reg(Point[] points) {

		float a = 0, b= 0, avgX= 0, avgY= 0;
		float arrX[] = new float[points.length];
		float arrY[] = new float[points.length];

		for (int i = 0; i < points.length; i++) {
			arrX[i] = points[i].x;
			arrY[i] = points[i].y;
		}
		a = cov(arrX, arrY) / var(arrX);
		avgX = avg(arrX);
		avgY = avg(arrY);
		b = avgY - (a * avgX);
		Line LINE = new Line(a,b);

		return LINE ;
	}

	// returns the deviation between point p and the line equation of the points
	public static float dev(Point p,Point[] points){
		float Dev=0;
		Line temp = linear_reg(points);
		Dev=dev(p,temp);
		return Dev;

	}

	// returns the deviation between point p and the line
	public static float dev(Point p,Line l){
		float Dev=0;
		Dev=(float)Math.abs(l.f(p.x)-p.y);// ׳¢׳¨׳� ׳�׳•׳—׳�׳˜

		return Dev;
	}


	public static float avg(Float[] curArray) {
		float count =0;
		for(int i=0 ; i<curArray.length ; i++)
		{
			count += curArray[i];
		}
		return (count/curArray.length);
	}
}
