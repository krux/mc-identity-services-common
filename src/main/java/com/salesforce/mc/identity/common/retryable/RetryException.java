package com.salesforce.mc.identity.common.retryable;

public class RetryException extends Exception {

	public final Exception e;

	public RetryException(final Exception e) {
		this.e = e;
	}
}
