public class Subnet {
	public int id;
	public String location;
	public String ip;
	public RouteTable routeTable;
	
	public Subnet() {
	}
	
	public Subnet(int id, String ip, String location) {
		this.id = id;
		this.ip = ip;
		this.location = location;
	}
	
	public void transfer(String msg) {
		if (routeTable.subnetList.contains(this)) {
			System.out.println(msg);
		}
	}
}
