package com.git.solr.auth;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.SystemDefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpParams;

@SuppressWarnings("deprecation")
public class ESystemDefaultHttpClient extends SystemDefaultHttpClient {

	private boolean keepAlive;

	/**
	 * 默认值5
	 */
	private int maxPerRoute = 5;

	/**
	 * 默认值10
	 */
	private int maxConnections = 10;

	public ESystemDefaultHttpClient(final HttpParams params) {
		super(params);
	}

	/**
	 * @param maxPerRoute
	 * @param maxConnections
	 */
	public ESystemDefaultHttpClient(int maxPerRoute, int maxConnections) {
		this.keepAlive = Boolean.TRUE;
		this.maxPerRoute = maxPerRoute;
		this.maxConnections = maxConnections;
	}

	/**
	 * @param keepAlive
	 * @param maxPerRoute
	 * @param maxConnections
	 */
	public ESystemDefaultHttpClient(boolean keepAlive, int maxPerRoute, int maxConnections) {
		super(null);
		this.keepAlive = keepAlive;
		this.maxPerRoute = maxPerRoute;
		this.maxConnections = maxConnections;
	}

	/**
	 * 扩展连接池
	 * 
	 * @return
	 */
	@Override
	protected ClientConnectionManager createClientConnectionManager() {
		final PoolingClientConnectionManager connmgr = new PoolingClientConnectionManager(
				SchemeRegistryFactory.createSystemDefault());
		if (keepAlive) {
			connmgr.setDefaultMaxPerRoute(maxPerRoute);
			connmgr.setMaxTotal(maxConnections);
		}
		return connmgr;
	}

}
