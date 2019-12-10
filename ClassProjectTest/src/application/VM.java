package application;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;

public class VM {
	String OSname;
	String OS;
	String Version;
	String Source;
	int VMEthernetPorts;
	ArrayList <String> ethernet;
	
	//Map<String , VM> map = new HashMap<String,VM>();
	static ArrayList<VM> VMList = new ArrayList<VM>(); //keeps track of all full instances of "VM"
	static ArrayList<String> VMNames = new ArrayList<String>();
	
	public VM(String OSname, String OS, String Version,String Source, int VMEthernetPorts, ArrayList<String> ethernet) {
		this.OSname = OSname;
		this.Version = Version;
		this.Source = Source;
		this.VMEthernetPorts = VMEthernetPorts;
		this.ethernet = ethernet;
		this.OS = OS;
		VMList.add(this);
		VMNames.add(this.OSname);
	}
	//accessor methods
	public ArrayList<String> getVMNameList() {
		return VMNames;
	}
	
	public VM() {//constructor for method access
		;
	}
	
	public String getOSname() {
		return OSname;
	}
	
	public String getOS() {
		return OS;
	}
	
	public String getVersion() {
		return Version;
	}
	
	public String getSource() {
		return Source;
	}
	
	public int VMEthernetPorts() {
		return VMEthernetPorts;
	}
	
	public ArrayList<String> getEthernet(){
		return ethernet;
	}
	
	public ArrayList<VM> getVMList(){
		return VMList;
	}
	//function to save the config
	public String saveVM() {
		ByteArrayOutputStream vmString = new ByteArrayOutputStream();
		PrintStream vmprint = new PrintStream(vmString);
		PrintStream old = System.out;
		System.out.flush();
		System.setOut(vmprint);
		VMList.forEach(vm -> {
			System.out.println(vm.vmtoString1());
			System.out.println(vm.vmtoString2(vm.getEthernet()));
		});
		System.out.flush();
		System.setOut(old);
		return vmString.toString();
	}
	//string method takes console out to print stream to get strings
	public String vmtoString2(ArrayList<String> vmEthernet) {
		ArrayList<String> TempvmEthernet = this.getEthernet();
		ByteArrayOutputStream vmEthernetString = new ByteArrayOutputStream();
		PrintStream vmEthernetprint = new PrintStream(vmEthernetString);
		PrintStream old = System.out;
		System.out.flush();
		System.setOut(vmEthernetprint);
		for(String ethernet:TempvmEthernet) {
			int i = 0;
			System.out.println("        eth" + i + " :\"" + ethernet + "\"");
		}
		System.out.println("}");
		System.out.flush();
		System.setOut(old);
		return vmEthernetString.toString();
	}
	
	public String vmtoString1() {
		return("vm " + this.OSname + " {\n" +
				"        os : " + this.OS + 
						"\n        ver : " + "\"" + this.Version
						+ "\"\n" + "        src : \"" + this.Source + "\""); 
	}
	
}