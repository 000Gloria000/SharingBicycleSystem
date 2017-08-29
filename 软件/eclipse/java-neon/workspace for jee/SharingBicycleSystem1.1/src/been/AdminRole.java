package been;
/**
 * 角色权限类
 * @author gloria
 *
 */
public class AdminRole {
	private String adminRoleId;  //角色权限编号
	private String requireUser;  //可以查询User表
	private String updateUser;  //可以增删改User表
	private String requireActivity;  //可以查询Activity表
	private String updateActivity;  //可以增删改Activity表
	private String requireAdmin;  //可以查询Admin表
	private String updateAdmin;  //可以增删改Admin表
	private String requireAdvice;  //可以查询Advice表
	private String updateAdvice;  //可以增删改Advice表
	private String requireBicycle;  //可以查询Bicycle表
	private String updateBicycle;  //可以增删改Bicycle表
	private String requireCyclingrecord;  //可以查询Cycling表
	private String updateCyclingrecord;  //可以增删改Cycling表
	private String requireDealrecord;  //可以查询Dealrecord表
	private String updateDealrecord;  //可以增删改Dealrecord表
	
	public AdminRole() {
		super();
	}
	
	public AdminRole(String adminRoleId, String requireUser, String updateUser, String requireActivity,
			String updateActivity, String requireAdmin, String updateAdmin, String requireAdvice, String updateAdvice,
			String requireBicycle, String updateBicycle, String requireCyclingrecord, String updateCyclingrecord,
			String requireDealrecord, String updateDealrecord) {
		super();
		this.adminRoleId = adminRoleId;
		this.requireUser = requireUser;
		this.updateUser = updateUser;
		this.requireActivity = requireActivity;
		this.updateActivity = updateActivity;
		this.requireAdmin = requireAdmin;
		this.updateAdmin = updateAdmin;
		this.requireAdvice = requireAdvice;
		this.updateAdvice = updateAdvice;
		this.requireBicycle = requireBicycle;
		this.updateBicycle = updateBicycle;
		this.requireCyclingrecord = requireCyclingrecord;
		this.updateCyclingrecord = updateCyclingrecord;
		this.requireDealrecord = requireDealrecord;
		this.updateDealrecord = updateDealrecord;
	}

	public String getAdminRoleId() {
		return adminRoleId;
	}
	public void setAdminRoleId(String adminRoleId) {
		this.adminRoleId = adminRoleId;
	}
	public String getRequireUser() {
		return requireUser;
	}
	public void setRequireUser(String requireUser) {
		this.requireUser = requireUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getRequireActivity() {
		return requireActivity;
	}
	public void setRequireActivity(String requireActivity) {
		this.requireActivity = requireActivity;
	}
	public String getUpdateActivity() {
		return updateActivity;
	}
	public void setUpdateActivity(String updateActivity) {
		this.updateActivity = updateActivity;
	}
	public String getRequireAdmin() {
		return requireAdmin;
	}
	public void setRequireAdmin(String requireAdmin) {
		this.requireAdmin = requireAdmin;
	}
	public String getUpdateAdmin() {
		return updateAdmin;
	}
	public void setUpdateAdmin(String updateAdmin) {
		this.updateAdmin = updateAdmin;
	}
	public String getRequireAdvice() {
		return requireAdvice;
	}
	public void setRequireAdvice(String requireAdvice) {
		this.requireAdvice = requireAdvice;
	}
	public String getUpdateAdvice() {
		return updateAdvice;
	}
	public void setUpdateAdvice(String updateAdvice) {
		this.updateAdvice = updateAdvice;
	}
	public String getRequireBicycle() {
		return requireBicycle;
	}
	public void setRequireBicycle(String requireBicycle) {
		this.requireBicycle = requireBicycle;
	}
	public String getUpdateBicycle() {
		return updateBicycle;
	}
	public void setUpdateBicycle(String updateBicycle) {
		this.updateBicycle = updateBicycle;
	}
	public String getRequireCyclingrecord() {
		return requireCyclingrecord;
	}
	public void setRequireCyclingrecord(String requireCyclingrecord) {
		this.requireCyclingrecord = requireCyclingrecord;
	}
	public String getUpdateCyclingrecord() {
		return updateCyclingrecord;
	}
	public void setUpdateCyclingrecord(String updateCyclingrecord) {
		this.updateCyclingrecord = updateCyclingrecord;
	}
	public String getRequireDealrecord() {
		return requireDealrecord;
	}
	public void setRequireDealrecord(String requireDealrecord) {
		this.requireDealrecord = requireDealrecord;
	}
	public String getUpdateDealrecord() {
		return updateDealrecord;
	}
	public void setUpdateDealrecord(String updateDealrecord) {
		this.updateDealrecord = updateDealrecord;
	}
	
	
}
