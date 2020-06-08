package algorithm;
public class Couple {

	private Person youngest;
	private Person oldest;

	public Couple(Person youngest, Person oldest) {
		this.youngest = youngest;
		this.oldest = oldest;
	}

	public long getDifference() {
		return getOldest().getBirthDate().getTime() - getYoungest().getBirthDate().getTime();
	}

	public Person getYoungest() {
		return youngest;
	}

	public Person getOldest() {
		return oldest;
	}
}
