package application;

import java.util.regex.Pattern;

//Program to validate IPv4 address in Java
class ValidateIPAddress
{
	private static final String IPv4_REGEX =//regex expression 
			"^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";

	private static final Pattern IPv4_PATTERN = Pattern.compile(IPv4_REGEX);
//the actual validation 
	public boolean isValidIPv4(String ip) {

		if (ip == null) {
			return false;
		}

		if (!IPv4_PATTERN.matcher(ip).matches())
			return false;
//splits string into the parts
		String[] parts = ip.split("\\.");

		// verify that each of the four subgroups of IPv4 address is legal
		try {
			for (String segment: parts) {
				// x.0.x.x is accepted but x.01.x.x is not
				if (Integer.parseInt(segment) > 255 ||//makes sure its correct length and in value range
							(segment.length() > 1 && segment.startsWith("0"))) {
					return false;
				}
			}
		} catch(NumberFormatException e) {
			return false;
		}

		return true;
	}
	

}
