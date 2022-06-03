public class NatGateWay extends GateWay {
	public Subnet subnet;
	public NatGateWay() {	}
	public NatGateWay(Subnet subnet) {
		this.subnet = subnet;
		send();
	}
	
	@Override
	public void send() {
	}
}
