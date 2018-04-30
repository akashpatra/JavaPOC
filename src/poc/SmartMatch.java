package poc;

import org.apache.commons.lang.StringUtils;

public class SmartMatch {

	public static void main(String[] args) {
		String customerName = "bhupinder singh";
		String referenceName = "bhupinder sing";
		String percentage = "85";
		
		System.out.println(isReferenceCustomerMatch(percentage, customerName, referenceName));
	}
	
	private static boolean isReferenceCustomerMatch(String thresholdPerc, String customerName,
            String referenceName) {
		float distance = StringUtils.getLevenshteinDistance(customerName, referenceName);
		System.out.println("Distance: " + distance);
		
        float length = customerName.length() > referenceName.length() ? customerName.length() : referenceName.length();
        System.out.println("Length: " + length);

        double perc = ((length - distance)/length)*100;
        System.out.println("Perc: " + String.valueOf(perc));
        
        if (Double.parseDouble(thresholdPerc) >= perc) {
        	return false;
        }

		return true;
	}

}
