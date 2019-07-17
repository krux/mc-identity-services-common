package com.salesforce.mc.identity.common.schema;

import java.util.List;

public class CBKDataPathResponse {

	private final List<String> dataPaths;
	private final String message;

	public CBKDataPathResponse(final List<String> dataPaths, final String message) {
		this.dataPaths = dataPaths;
		this.message = message;
	}

	public List<String> getDataPaths() {
		return dataPaths;
	}

	public String getMessage() {
		return message;
	}
}
