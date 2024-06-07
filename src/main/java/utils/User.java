package utils;

import java.util.ArrayList;
import java.util.List;

public class User {

	@Override
	public String toString() {
		return "User [customer_id=" + customer_id + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", account_type=" + account_type + ", balence=" + balence + ", preferences="
				+ preferences + "]";
	}

	private Long customer_id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String account_type;
	private String balence;
	private List<UserPreference> preferences = new ArrayList<>();

	public User() {
	}

	public enum Status {
		ACTIVE, INACTIVE
	}

	public Long getId() {
		return customer_id;
	}

	public void setId(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomerName() {
		return name;
	}

	public void setCustomername(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAccounttype() {
		return account_type;
	}

	public void setAccountType(String account_type) {
		this.account_type = account_type;
	}

	public List<UserPreference> getCustomerPreferences() {
		return preferences;
	}

	public void setPreferences(List<UserPreference> preferences) {
		this.preferences = preferences;
	}

	public String getBalence() {
		return balence;
	}

	public void setBalence(String balence) {
		this.balence = balence;
	}

}