package userprofile.model;

import userprofile.model.ports.RadioException;

class NotNullNorEmpty<T> {

	private T value;
	
	public NotNullNorEmpty(T value, String description) {
		if (value == null || "".equals(value)) {
			throw new RadioException(description + " must be valid...");
		}
		this.value = value;
	}
	
	public T value() {
		return value;
	}
}
