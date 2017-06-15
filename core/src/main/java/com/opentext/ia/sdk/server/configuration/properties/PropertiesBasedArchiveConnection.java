/*
 * Copyright (c) 2016-2017 by OpenText Corporation. All Rights Reserved.
 */
package com.opentext.ia.sdk.server.configuration.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.opentext.ia.sdk.client.api.ArchiveConnection;


public class PropertiesBasedArchiveConnection extends ArchiveConnection implements InfoArchiveConfigurationProperties {

  public PropertiesBasedArchiveConnection(InputStream configuration) throws IOException {
    this(readConfigurationFrom(configuration));
  }

  private static Map<String, String> readConfigurationFrom(InputStream configuration) throws IOException {
    Map<String, String> result = new HashMap<>();
    Properties properties = new Properties();
    properties.load(configuration);
    properties.stringPropertyNames().forEach(name -> result.put(name, properties.getProperty(name)));
    return result;
  }

  public PropertiesBasedArchiveConnection(Map<String, String> configuration) {
    setAuthenticationGateway(configuration.get(SERVER_AUTHENTICATION_GATEWAY));
    setAuthenticationPassword(configuration.get(SERVER_AUTHENTICATION_PASSWORD));
    setAuthenticationToken(configuration.get(SERVER_AUTENTICATION_TOKEN));
    setAuthenticationUser(configuration.get(SERVER_AUTHENTICATION_USER));
    setBillboardUri(configuration.get(SERVER_URI));
    setClientId(configuration.get(SERVER_CLIENT_ID));
    setClientSecret(configuration.get(SERVER_CLIENT_SECRET));
    setHttpClientClassName(configuration.get(HTTP_CLIENT_CLASSNAME));
    setProxyHost(configuration.get(PROXY_HOST));
    setProxyPort(configuration.get(PROXY_PORT));
  }

}
