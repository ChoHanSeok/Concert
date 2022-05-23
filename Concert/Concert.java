package vo;

public class Concert {
	private int conid;
	private String conname;
	private String conhost;
	private int price;
	public int getConid() {
		return conid;
	}
	public void setConid(int conid) {
		this.conid = conid;
	}
	public String getConname() {
		return conname;
	}
	public void setConname(String conname) {
		this.conname = conname;
	}
	public String getConhost() {
		return conhost;
	}
	public void setConhost(String conhost) {
		this.conhost = conhost;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Concert [conid=" + conid + ", conname=" + conname + ", conhost=" + conhost + ", price=" + price + "]";
	}
	
	
	
}