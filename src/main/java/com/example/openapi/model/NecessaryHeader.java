/**
 * 
 */
package com.example.openapi.model;

import javax.ws.rs.core.HttpHeaders;

/**
 * @author 86211
 *
 */
public abstract interface NecessaryHeader extends HttpHeaders {
    public static final String AUTHORIZATION = "Authorization";
    public static final String UUID = "uuid";
    public static final String CLIENTID = "clientId";
    public static final String DATASOURCE = "datasource";

}
