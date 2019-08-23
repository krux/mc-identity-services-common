package com.salesforce.mc.identity.common.retryable;

import java.util.Optional;
import java.util.concurrent.Callable;

public class RetryCallable<T> {

	private final Callable<T> callable;
	private final RetryPolicy policy;

	public RetryCallable(Callable<T> callable, RetryPolicy policy) {
		this.callable = callable;
		this.policy = policy;
	}

	/**
	 *
	 * @return
	 * @throws RetryException
	 */
	public T call() throws RetryException {
		int attempts = 0;
		Optional<T> result = Optional.empty();
		while (++attempts <= policy.getRetries()) {
			try {
				result = Optional.of(callable.call());
			} catch (Exception e) {
				if (!policy.getExceptionClasses().isEmpty() && !policy.getExceptionClasses().contains(e.getClass()))
					throw new RetryException(e);
				try {
					int factor = policy.isExponentialBackOff() ? (int) Math.pow(2, attempts - 1) : 1;
					Thread.sleep(policy.getBackOffTimeMillis() * factor);
				} catch (InterruptedException e1) {
					throw new RetryException(e1);
				}
				continue;
			}
		}
		if (!result.isPresent())
			throw new RetryException(new Exception("Multiple attempts in calling the callable resulted in exceptions."));
		return result.get();

	}

}
