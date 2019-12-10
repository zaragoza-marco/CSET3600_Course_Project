package application;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Hub {
	String name;
	String hubNetworkAddress;
	int EthernetPorts;
	String subnet;
	//Master list; keeps track of all hubs created
	static ArrayList<Hub> HubList = new ArrayList<Hub>(); 
	
	
	public Hub(String name, String hubNetworkAddress, int EthernetPorts, String subnet) {
		this.name = name;
		this.hubNetworkAddress = hubNetworkAddress;
		this.EthernetPorts = EthernetPorts;
		this.subnet = subnet;
		HubList.add(this);
	}
	
		//constructor to access methods easily
	public Hub() {
		;
	}
	//part one of the file output
	public String hubToString1() {
		return("hub " + this.name + " {\n"+
				"	subnet : \"" + this.hubNetworkAddress + "\"\n"+
				"	netmask : \"" + this.subnet + "\"\n}");
	}
	//how the hub config is outputted
	public String saveHub() {
		ByteArrayOutputStream HubString = new ByteArrayOutputStream();//creates a byte output stream to save string
		PrintStream Hubprint = new PrintStream(HubString);
		PrintStream old = System.out;//console output stream before save
		System.out.flush();//clears any and all system out data
		System.setOut(Hubprint);//sets it to the outs stream
		HubList.forEach(vm -> {//iterates through the list  
			System.out.println(vm.hubToString1());
			//System.out.println(vm.vmtoString2(vm.getEthernet()));
		});
		System.out.flush();
		System.setOut(old);
		return HubString.toString();//returns the string to be saved in file
	}	
	
	public ArrayList<Hub> getHubList(){
		return HubList;//legacy code
	}

}
