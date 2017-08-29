package been;

/**
 * 交易记录类
 * @author gloria
 *
 */
public class DealRecord {
	private String dealRecordId;  //交易记录编号
	private String userId;  //交易用户编号
	private String actionType;  //交易类型，1为充值，0为消费
	private String money;  //交易金额
	private String actionTime;  //交易时间，默认为系统当前时间
	public String getDealRecordId() {
		return dealRecordId;
	}
	public void setDealRecordId(String dealRecordId) {
		this.dealRecordId = dealRecordId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getActionTime() {
		return actionTime;
	}
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}
	
	
}
