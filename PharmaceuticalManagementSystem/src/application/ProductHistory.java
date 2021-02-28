package application;

public class ProductHistory {
	private int product_history_id;	
	private int product_id;	
	private String product_name;	
	private int product_quantity;	
	private String customer_name;	
	private String customer_phone;	
	private int total_price;
	public ProductHistory(int product_history_id, int product_id, String product_name, int product_quantity,
			String customer_name, String customer_phone, int total_price) {
		super();
		this.product_history_id = product_history_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_quantity = product_quantity;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.total_price = total_price;
	}
	public int getProduct_history_id() {
		return product_history_id;
	}
	public void setProduct_history_id(int product_history_id) {
		this.product_history_id = product_history_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
}
