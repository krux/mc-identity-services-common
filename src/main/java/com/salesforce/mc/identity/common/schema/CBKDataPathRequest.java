package com.salesforce.mc.identity.common.schema;

import java.util.List;

public class CBKDataPathRequest {

	private final String org;
	private final String basePath;
	private final List<String> bridgeKeys;
	private final List<String> sourceTypes;

	public CBKDataPathRequest(final String org, final String basePath, final List<String> bridgeKeys,
			final List<String> sourceTypes) {
		this.org = org;
		this.basePath = basePath;
		this.bridgeKeys = bridgeKeys;
		this.sourceTypes = sourceTypes;
	}

	public String getOrg() {
		return org;
	}

	public String getBasePath() {
		return basePath;
	}

	public List<String> getBridgeKeys() {
		return bridgeKeys;
	}

	public List<String> getSourceTypes() {
		return sourceTypes;
	}
}
