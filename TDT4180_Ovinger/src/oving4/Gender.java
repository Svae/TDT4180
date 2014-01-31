package oving4;

public enum Gender {
	male,female;
	public String toString() {
		return this == Gender.female ? "Female":"Male";
	};
}
