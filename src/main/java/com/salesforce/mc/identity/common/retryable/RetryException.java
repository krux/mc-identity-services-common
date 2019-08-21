package com.salesforce.mc.identity.common.retryable;

public class RetryException extends Exception {

	private static final long serialVersionUID = -7407775622713419770L;
	public final Exception e;

	public RetryException(final Exception e) {
		this.e = e;
	}
}
