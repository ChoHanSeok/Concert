package vo;

public class Ticketing {
	private int orderid;
	private int custid;
	private int conid;
	private int saleprice;
	
	
	public int getOrderid() {
		return orderid;
	}


	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}


	public int getCustid() {
		return custid;
	}


	public void setCustid(int custid) {
		this.custid = custid;
	}


	public int getConid() {
		return conid;
	}


	public void setConid(int conid) {
		this.conid = conid;
	}


	public int getSaleprice() {
		return saleprice;
	}


	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}


	@Override
	public String toString() {
		return "Ticketing [orderid=" + orderid + ", custid=" + custid + ", conid=" + conid + ", saleprice=" + saleprice
				+ "]";
	}
	
	

}
