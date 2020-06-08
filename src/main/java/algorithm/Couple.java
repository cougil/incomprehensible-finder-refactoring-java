package algorithm;
public class Couple {

	public Couple() {
	}

	public Couple(Person youngest, Person oldest) {
		this.youngest = youngest;
		this.oldest = oldest;
	}

	public Person youngest;
	public Person oldest;
	public long difference;
}
