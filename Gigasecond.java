import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

	public static final long GIGASECONDS = 1_000_000_000;
	LocalDateTime birthday;
	
	public Gigasecond(LocalDate birthday) {
		this.birthday = birthday.atStartOfDay();
	}
	
	public Gigasecond(LocalDateTime birthday) {
		this.birthday = birthday;
	}
	
	public LocalDateTime getDate() {
		return birthday.plusSeconds(GIGASECONDS);
	}
	
}
