package been;

/**
 * 活动类
 * @author gloria
 *
 */
public class Activity {
	private String activityId;  //活动编号
	private String userId;  //创建者编号
	private String title;  //活动标题
	private String createTime;  //活动创建时间
	private String startTime;  //活动起始时间
	private String endTime;  //活动结束时间
	private String description;  //活动描述
	
	public Activity() {
		super();
	}
	
	
	public Activity(String activityId, String userId, String title, String createTime, String startTime, String endTime,
			String description) {
		super();
		this.activityId = activityId;
		this.userId = userId;
		this.title = title;
		this.createTime = createTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}

	public Activity(String activityId, String userId, String title, String description) {
		super();
		this.activityId = activityId;
		this.userId = userId;
		this.title = title;
		this.description = description;
	}


	public String getActivityId() {
		return activityId;
	}
	

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", userId=" + userId + ", title=" + title + ", createTime="
				+ createTime + ", startTime=" + startTime + ", endTime=" + endTime + ", description=" + description
				+ "]";
	}
	
	
}
