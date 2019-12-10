package application;

public class ValidateSubnet {
	private boolean subnetValid = true;
	String subnetString;
	
	public ValidateSubnet() {
		;
	}//The only easy way of validating a subnet mask; since networks can be subnetted and supernetted no
	//also anything further would need specified 
	
	public ValidateSubnet(String subnetString) {
		switch(subnetString) {
		case "0.0.0.0":
			break;
		case "128.0.0.0":
			break;
		case "192.0.0.0":
			break;
		case "224.0.0.0":
			break;
		case "240.0.0.0":
			break;
		case "248.0.0.0":
			break;
		case "252.0.0.0":
			break;
		case "254.0.0.0":
			break;
		case "255.0.0.0":
			break;
		case "255.128.0.0":
			break;
		case "255.192.0.0":
			break;
		case "255.225.0.0":
			break;
		case "255.240.0.0":
			break;
		case "255.248.0.0":
			break;
		case "255.252.0.0":
			break;
		case "255.254.0.0":
			break;
		case "255.255.0.0":
			break;
		case "255.255.128.0":
			break;
		case "255.255.192.0":
			break;
		case "255.255.224.0":
			break;
		case "255.255.240.0":
			break;
		case "255.255.248.0":
			break;	
		case "255.255.252.0":
			break;
		case "255.255.254.0":
			break;
		case "255.255.255.0":
			break;
		case "255.255.255.192":
			break;
		case "255.255.255.224":
			break;
		case "255.255.255.240":
			break;
		case "255.255.255.248":
			break;
		case "255.255.255.252":
			break;
		case "255.255.255.254":
			break;
		case "255.255.255.255":
			break;		
		default:
			subnetValid = false;
		}
		
	}
	//returns boolean 
	public boolean getsubnetValid() {
		return subnetValid;
	}

}
