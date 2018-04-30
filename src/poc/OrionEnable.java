package poc;

import java.util.Arrays;
import java.util.List;

public class OrionEnable {

	private static String loggedCircle = "Delhi";
	private static String feature = "orion_Delhi";
	private static String DELIMITER = "orion_";
	
	public static void main(String[] args) {
		System.out.println("Circle is 0 : " + isOrionDisabledCircle());
	}
	
	private static String getDisabledCircles(String feature) {
		if (feature.contains(DELIMITER)) {
			int lengthOfDelimiter = feature.indexOf(DELIMITER) + DELIMITER.length();
			if (feature.length() > lengthOfDelimiter) {
				System.out.println("SubString: " + feature.substring(lengthOfDelimiter));
				return feature.substring(lengthOfDelimiter);
			}
		}
		return "";
	}
	
	/**
     * To check orion is disabled or not in the circle.
     *
     * @return
     */
    private static boolean isOrionDisabledCircle() {
        String CIRCLE_DELIMITER = ":";
        String disabledCircle = getDisabledCircles(feature);
        List<String> circleList = Arrays.asList(disabledCircle.split(CIRCLE_DELIMITER));
        if (circleList.contains(loggedCircle)) {
            return true;
        }
        return false;
    }

}
