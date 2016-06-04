import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

public class Meetup {

	private int month;
	private int year;
	private DateTime firstOfMonth;

	public Meetup(int month, int year) {
		this.month = month;
		this.year = year;
		firstOfMonth = new DateTime(this.year, this.month, 1, 0, 0);
	}

	public DateTime day(int day_of_week, MeetupSchedule schedule) {
		DateTime firstOccurrence = findFirstDayOfWeek(day_of_week);
		switch (schedule) {
			case FIRST:  return firstOccurrence; 
			case SECOND: return firstOccurrence.plusWeeks(1);
			case THIRD:  return firstOccurrence.plusWeeks(2);
			case FOURTH: return firstOccurrence.plusWeeks(3);
			case LAST:   return findLastDayOfWeek(day_of_week);  
			default:     return findTeenthDayOfWeek(firstOccurrence);
		}
	}
	
	private DateTime findFirstDayOfWeek(int day_of_week) {
		DateTime date = firstOfMonth;
		while (date.getDayOfWeek() != day_of_week) {
			date = date.plusDays(1);
		}
	    return date;
	}

	private DateTime findLastDayOfWeek(int day_of_week) {
		DateTime date = firstOfMonth.plusMonths(1).minusDays(1);
		while (date.getDayOfWeek() != day_of_week) {
			date = date.minusDays(1);
		}
	    return date;
	}
	
	private DateTime findTeenthDayOfWeek(DateTime date) {
		while (date.getDayOfMonth() < 13) {
			date = date.plusWeeks(1);
		}
		return date;
	}
}