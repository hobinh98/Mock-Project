package edu.fa.dto;

public class DtoResponseValidate {

	private boolean success;

	private String message;

	public DtoResponseValidate() {
		super();
	}

	public DtoResponseValidate(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DtoResponseValidate [success=" + success + ", message=" + message + "]";
	}
}
