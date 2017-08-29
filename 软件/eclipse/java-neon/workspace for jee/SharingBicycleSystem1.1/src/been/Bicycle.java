package been;
/**
 * 自行车类
 * @author gloria
 *
 */
public class Bicycle {
	private String bicycleId;  //自行车编号
	private String from = "0";  //自行车来源，0为公司采购
	private String time;  //自行车加入时间
	private String photo;  //自行车照片
	private String lockId;  //锁编号
	private String locationX;  //自行车最后位置X坐标
	private String locationY;  //自行车最后位置Y坐标
	private String status;  //自行车使用状态，0为停止使用，1为正在使用
	private String energy;  //自行车车锁电量
	public String getBicycleId() {
		return bicycleId;
	}
	public void setBicycleId(String bicycleId) {
		this.bicycleId = bicycleId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getLockId() {
		return lockId;
	}
	public void setLockId(String lockId) {
		this.lockId = lockId;
	}
	public String getLocationX() {
		return locationX;
	}
	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}
	public String getLocationY() {
		return locationY;
	}
	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEnergy() {
		return energy;
	}
	public void setEnergy(String energy) {
		this.energy = energy;
	}
	
	
}
