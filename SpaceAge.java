public class SpaceAge {

	private long seconds;
	public static final int EARTH_LUNAR_YEAR_SECONDS = 31557600;
	public static final double EARTH_DAYS_PER_YEAR = 365.25;
	
	private enum Planet {
		MERCURY (0.2408467),
		VENUS 	(0.61519726),
		MARS 	(1.8808158),
		EARTH 	(1),
		JUPITER (11.862615),
		SATURN 	(29.447498),
		URANUS 	(84.016846),
		NEPTUNE (164.79132);
	
		private final double solarYear;
		Planet (double solarYear) {
			this.solarYear = solarYear;
		}
		public double getEarthYearSeconds(){
			return solarYear * EARTH_LUNAR_YEAR_SECONDS;
		}
		public double getYearsEquivalentToEarth(long seconds){
			return seconds / (solarYear * EARTH_LUNAR_YEAR_SECONDS);
		}
	}

	public SpaceAge(long seconds){
		this.seconds = seconds;
	}
	
	private double getAge(Planet planet) {
		return planet.getYearsEquivalentToEarth(seconds);
	}
	
	public long getSeconds() {
		return seconds;
	}
	
	public double onEarth(){
		return getAge(Planet.EARTH);
	}
	
	public double onMercury(){
		return getAge(Planet.MERCURY);
	}
	
	public double onVenus(){
		return getAge(Planet.VENUS);
	}
	
	public double onMars(){
		return getAge(Planet.MARS);
	}
	
	public double onJupiter(){
		return getAge(Planet.JUPITER);
	}
	
	public double onSaturn(){
		return getAge(Planet.SATURN);
	}
	
	public double onUranus(){
		return getAge(Planet.URANUS);
	}
	
	public double onNeptune(){
		return getAge(Planet.NEPTUNE);
	}
}