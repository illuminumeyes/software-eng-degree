import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Quick-and-Dirty class representing a kill on my killfeed
 * @author Kris
 *
 */
public class KillEvent {
	private LocalDateTime _time;
	private String _killer;
	private String _victim;
	private String _weapon;
	
	/**
	 * Generates a KillEvent object from the specified parameters
	 * Ordered this way so that the macro-generated code will actually construct the objects
	 * @param time The server-generated time the kill happened
	 * @param killer The player doing the Killing
	 * @param victim The player who was killed
	 * @param weapon The weapon used
	 */
	public KillEvent(String time, String killer, String victim, String weapon) {
		_time = LocalDateTime.parse(time,DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss"));
		_killer = killer;
		_victim = victim;
		_weapon = weapon;
	}
	
	/**
	 * Returns when the kill happened, in the server's weird format
	 */
	public LocalDateTime getTime() {
		return _time;
	}
	
	/**
	 * Returns the name of the player who did the killing
	 */
	public String getKiller() {
		return _killer;
	}
	
	/**
	 * Returns the name of the player who was killed
	 */
	public String getVictim() {
		return _victim;
	}
	
	/**
	 * Returns the name of the weapon used to do the killing
	 * Note: The server sometimes gives a blank, for "unknown"
	 */
	public String getWeapon() {
		return _weapon;
	}
}
