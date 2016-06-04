import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

public class Meetup {

	private int month;
	private int year;

	public Meetup(int month, int year) {
		this.month = month;
		this.year = year;
	}

	public DateTime day(int day_of_week, MeetupSchedule schedule) {

		switch (schedule) {
			case FIRST:  return findDate(day_of_week, 0); 
			case SECOND: return findDate(day_of_week, 1);
			case THIRD:  return findDate(day_of_week, 2);
			case FOURTH: return findDate(day_of_week, 3);
			default:
		}

		// case of the LAST
		DateTime date = new DateTime(this.year, this.month, 1, 0, 0);
		if (schedule == MeetupSchedule.LAST) {
		    date = date.dayOfMonth()
		           	    .withMaximumValue()
		                .dayOfWeek()
		                .setCopy(day_of_week);
		    if (date.getMonthOfYear() != month) {
		    	return date.dayOfWeek().addToCopy(-7);
		    }
	    return date;
		}
		
		// Default case of the TEENTHS
		date = findDate(day_of_week, 0);
		while (date.getDayOfMonth() < 13) {
			date = date.dayOfWeek().addToCopy(7);
		}
		return date;
	}
	
	/** Find date based on the first occurrence of the day_of_week in the month
	 */
	private DateTime findDate(int day_of_week, int week_adjust) {
		DateTime date = new DateTime(this.year, this.month, 1, 0, 0);
	    date = date.dayOfMonth()
	           	    .withMinimumValue()
	                .dayOfWeek()
	                .setCopy(day_of_week);
	    if (date.getMonthOfYear() < month) {
	        date = date.dayOfWeek().addToCopy(7);
	    }
	    return date.dayOfWeek().addToCopy(week_adjust * 7);
	}
}