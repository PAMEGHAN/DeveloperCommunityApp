package com.cg.exception;

public class ResponseNotFoundException  extends RuntimeException {
	public String toString() {
		return "Response not found";
	}

}
