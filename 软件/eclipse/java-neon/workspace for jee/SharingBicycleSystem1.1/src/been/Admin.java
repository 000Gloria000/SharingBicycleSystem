package been;

/**
 * 管理员类
 * @author gloria
 *
 */
public class Admin {
	private String adminId;  //管理员编号
	private String userName;  //登陆用户名
	private String password;  //登陆密码
	private String name;  //管理员姓名
	private String adminRoleId;  //权限
	
	public Admin() {
		super();
	}
	
	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public Admin(String adminId, String userName, String password, String name, String adminRoleId) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.adminRoleId = adminRoleId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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

	public String getAdminRoleId() {
		return adminRoleId;
	}

	public void setAdminRoleId(String adminRoleId) {
		this.adminRoleId = adminRoleId;
	}
}
