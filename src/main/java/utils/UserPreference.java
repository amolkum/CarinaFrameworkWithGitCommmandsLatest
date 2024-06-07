package utils;

public class UserPreference {

	@Override
	public String toString() {
		return "UserPreference [customer_id=" + customer_id + ", account_id=" + account_id + "]";
	}

	private Long customer_id;
	private Long account_id;

	public enum Name {
		DEFAULT_DASHBOARD, REFRESH_INTERVAL, THEME
	}

	public Long getCustomerId() {
		return customer_id;
	}

	public void setId(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Long getAccountid() {
		return account_id;
	}

	public void setAccountId(Long account_id) {
		this.account_id = account_id;
	}

}
