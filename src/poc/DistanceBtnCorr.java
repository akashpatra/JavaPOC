package poc;

import java.util.Scanner;

public class DistanceBtnCorr {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double sLat,sLon,eLat,eLon;
		sLat = in.nextDouble();
		sLon = in.nextDouble();
		eLat = in.nextDouble();
		eLon = in.nextDouble();
		
		System.out.println("Dist: " + calculateDistance(sLat, sLon, eLat,eLon));
	}
	
	public static double calculateDistance(double startLatitude, double startLongitude, double endLatitude, double endLongitude) {
        double latDistance = Math.toRadians(endLatitude - startLatitude);
        double lonDistance = Math.toRadians(endLongitude - startLongitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(startLatitude)) * Math.cos(Math.toRadians(endLatitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = 6371 * c * 1000; // convert to meters
        System.out.println("Org Dist: " + distance);
        
        distance = Math.pow(distance, 2) /* + MyMath.pow(height, 2)*/;

        return Math.sqrt(distance);
    }

}
