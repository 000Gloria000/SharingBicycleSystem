package been;

/**
 * 用户类
 * @author gloria
 *
 */
public class User {
	private String userId;  //用户编号
	private String userName;  //登陆账户名
	private String password;  //登陆密码
	private String name;  //用户姓名
	private String cardNumber;  //持有卡卡号
	private String score;  //积分
	private String phone;  //手机号
	private String status;  //冻结项，0为冻结，1为未冻结
	private String balance;  //卡内余额	
	
	public User() {
		super();
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(String userId, String userName, String password, String name, String cardNumber, String score,
			String phone, String status, String balance) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.cardNumber = cardNumber;
		this.score = score;
		this.phone = phone;
		this.status = status;
		this.balance = balance;
	}

	public User(String userName, String password, String name, String cardNumber, String score, String phone,
			String status, String balance) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.cardNumber = cardNumber;
		this.score = score;
		this.phone = phone;
		this.status = status;
		this.balance = balance;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	
	
}
