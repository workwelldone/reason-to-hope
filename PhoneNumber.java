public class PhoneNumber {

	private String phoneNumber;
	private static final String INVALID = "0000000000";
	
	public PhoneNumber(String phoneNumber) {
		reduce(phoneNumber);
	}
	
	private final void reduce(String number){
		phoneNumber = number.replaceAll("[^0-9]", "");
		if (phoneNumber.charAt(0) == '1' && phoneNumber.length() == 11) phoneNumber = phoneNumber.substring(1);
		if (phoneNumber.length() != 10) phoneNumber = INVALID;
	}
	
	public String getNumber(){
		return phoneNumber;
	}

	public String getAreaCode(){
		return phoneNumber.substring(0, 3);
	}

	public String pretty(){
		return "(" + getAreaCode() + ") " + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6); 
	}
	
}
