package com.salesforce.mc.identity.common.schema;

import java.util.List;

/**
 * Schema of the CBK Data path's request object
 * @author Tej Vepa
 *
 */
public class CBKDataPathRequest {

	private final String orgUUID;
	private final String basePath;
	private final List<String> bridgeKeys;
	private final List<String> sourceTypes;
	private final String dbMode;

	public CBKDataPathRequest(final String orgUUID, final String basePath, final List<String> bridgeKeys,
			final List<String> sourceTypes, final String dbMode) {
		this.orgUUID = orgUUID;
		this.basePath = basePath;
		this.bridgeKeys = bridgeKeys;
		this.sourceTypes = sourceTypes;
		this.dbMode = dbMode;
	}

	public String getOrgUUID() {
		return orgUUID;
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

	public String getDBMode() {
		return dbMode;
	}
}
