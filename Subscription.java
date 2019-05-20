
public class Subscription {
	private long userId;
	private int programCode;
	private int seasonId;
	
	public Subscription(long userId, int programCode, int seasonId) {
		this.userId = userId;
		this.programCode = programCode;
		this.seasonId = seasonId;
	}
	
	public long getUserId() {
		return userId;
	}
	public int getProgramCode() {
		return programCode;
	}
	public int getSeasonId() {
		return seasonId;
	}
	
	@Override
	public String toString() {
		return "(" + userId + ", " + programCode + ", " + seasonId + ")";
	}
}
