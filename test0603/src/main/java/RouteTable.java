import java.util.ArrayList;
import java.util.List;

public class RouteTable {
	public int id;
	private GateWay gateWay;
	public List<Subnet> subnetList = new ArrayList<>();
	
  public void	setGateWay(GateWay gateWay) {
		this.gateWay = gateWay;
	}
	
	public GateWay getGateWay() {
		return this.gateWay;
	}
	
	public void addSubnet(Subnet subnet) {
		subnetList.add(subnet);
		subnet.routeTable = this;
	}
}
