package been;
/**
 * 建议反馈表
 * @author gloria
 *
 */
public class Advice {
	private String adviseId;  //反馈表编号
	private String adminId;  //处理者（管理员）编号
	private String creator;  //反馈者（用户）编号
	private String title;  //反馈表标题
	private String content;  //反馈表内容
	private String createTime;  //反馈表创建时间
	private String status;  //反馈表状态，0代表未阅读，1代表已被阅读但未回复，2代表已被阅读且已回复
	private String replyContent;  //反馈回复内容
	private String replyTime;  //反馈回复时间
	
	
	public Advice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Advice(String adviseId, String creator, String title, String content, String status) {
		super();
		this.adviseId = adviseId;
		this.creator = creator;
		this.title = title;
		this.content = content;
		this.status = status;
	}

	public String getAdviseId() {
		return adviseId;
	}
	public void setAdviseId(String adviseId) {
		this.adviseId = adviseId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	@Override
	public String toString() {
		return "Advice [adviseId=" + adviseId + ", adminId=" + adminId + ", creator=" + creator + ", title=" + title
				+ ", content=" + content + ", createTime=" + createTime + ", status=" + status + ", replyContent="
				+ replyContent + ", replyTime=" + replyTime + "]";
	}
	
	
}
