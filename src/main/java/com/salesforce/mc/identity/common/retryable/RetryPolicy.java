package com.salesforce.mc.identity.common.retryable;

import java.util.HashSet;
import java.util.Set;

public class RetryPolicy {

	private static final int DEFAULT_BACKOFF_TIME_MILLIS = 500;
	private static final int DEFAULT_RETRIES = 5;

	private final int backOffTimeMillis;
	private final int retries;
	private final Set<Class<? extends Exception>> exceptionClasses;

	private RetryPolicy(final int backOffTimeMillis, final int retries, final Set<Class<? extends Exception>> exceptionClasses) {
		this.backOffTimeMillis = backOffTimeMillis;
		this.retries = retries;
		this.exceptionClasses = exceptionClasses;
	}

	public int getBackOffTimeMillis() {
		return backOffTimeMillis;
	}

	public int getRetries() {
		return retries;
	}

	public Set<Class<? extends Exception>> getExceptionClasses() {
		return exceptionClasses;
	}

	public static class RetryPolicyBuilder {
		private int backOffTimeMillis;
		private int retries;
		private final Set<Class<? extends Exception>> exceptionClasses = new HashSet<>();

		public static RetryPolicyBuilder builder() {
			return new RetryPolicyBuilder();
		}

		public RetryPolicyBuilder withBackOffTime(int timeMillis) {
			backOffTimeMillis = timeMillis;
			return this;
		}

		public RetryPolicyBuilder withRetries(int retries) {
			this.retries = retries;
			return this;
		}

		public RetryPolicyBuilder onException(Class<? extends Exception> clazz) {
			exceptionClasses.add(clazz);
			return this;
		}

		public RetryPolicy build() {
			if (backOffTimeMillis == 0) {
				backOffTimeMillis = DEFAULT_BACKOFF_TIME_MILLIS;
			}
			if (retries == 0) {
				retries = DEFAULT_RETRIES;
			}
			return new RetryPolicy(backOffTimeMillis, retries, exceptionClasses);
		}
	}

}
