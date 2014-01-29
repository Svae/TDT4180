package oving2;

public enum Gender {
	male,female;
	public String toString() {
		return this == Gender.female ? "Female":"Male";
	};
}
