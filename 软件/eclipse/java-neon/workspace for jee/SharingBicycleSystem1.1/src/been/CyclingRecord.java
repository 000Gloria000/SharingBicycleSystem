package been;
/**
 * 骑行记录类
 * @author gloria
 *
 */
public class CyclingRecord {
	private String cyclingRecordId;  //骑行记录编号
	private String bicycleId;  //自行车编号
	private String userId;  //用户编号
	private String startTime;  //骑行起始时间
	private String endTime;  //骑行结束时间
	private String startLocX;  //骑行起始位置X坐标
	private String startLocY;  //骑行起始位置Y坐标
	private String endLocX;  //骑行结束位置X坐标
	private String endLocY;  //骑行结束位置Y坐标
	public String getCyclingRecordId() {
		return cyclingRecordId;
	}
	public void setCyclingRecordId(String cyclingRecordId) {
		this.cyclingRecordId = cyclingRecordId;
	}
	public String getBicycleId() {
		return bicycleId;
	}
	public void setBicycleId(String bicycleId) {
		this.bicycleId = bicycleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStartLocX() {
		return startLocX;
	}
	public void setStartLocX(String startLocX) {
		this.startLocX = startLocX;
	}
	public String getStartLocY() {
		return startLocY;
	}
	public void setStartLocY(String startLocY) {
		this.startLocY = startLocY;
	}
	public String getEndLocX() {
		return endLocX;
	}
	public void setEndLocX(String endLocX) {
		this.endLocX = endLocX;
	}
	public String getEndLocY() {
		return endLocY;
	}
	public void setEndLocY(String endLocY) {
		this.endLocY = endLocY;
	}
	
	
}
