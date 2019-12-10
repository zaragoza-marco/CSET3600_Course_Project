
package application;
//unused class that was going to be the master
public class NetworkDevice {
	String name;
	String IP;
	//String SubMask;
	int EthernetPorts;
	
	public NetworkDevice(String name, String IP, int EthernetPorts) {
		this.name = name;
		this.IP = IP;
		this.EthernetPorts = EthernetPorts;
	}
	
	public String getName() {
		return name;
	}
	
	public String getIP() {
		return IP;
	}
	
	public int EthernetPorts() {
		return EthernetPorts;
	}

}
