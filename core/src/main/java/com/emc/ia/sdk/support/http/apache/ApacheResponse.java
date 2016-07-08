/*
 * Copyright (c) 2016 EMC Corporation. All Rights Reserved.
 */
package com.emc.ia.sdk.support.http.apache;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

import com.emc.ia.sdk.support.http.Response;


public class ApacheResponse implements Response {

  private final CloseableHttpResponse wrapped;

  public ApacheResponse(CloseableHttpResponse wrapped) {
    this.wrapped = wrapped;
  }

  @Override
  public void close() throws IOException {
    wrapped.close();
  }

  @Override
  public String getHeaderValue(String name, String defaultValue) {
    Header header = wrapped.getFirstHeader(name);
    return header == null ? defaultValue : header.getValue();
  }

  @Override
  public boolean getHeaderValue(String name, boolean defaultValue) {
    return Boolean.parseBoolean(getHeaderValue(name, Boolean.toString(defaultValue)));
  }

  @Override
  public int getHeaderValue(String name, int defaultValue) {
    return Integer.parseInt(getHeaderValue(name, Integer.toString(defaultValue)));
  }

  @Override
  public InputStream getBody() throws IOException {
    HttpEntity entity = wrapped.getEntity();
    return entity == null ? null : entity.getContent();
  }

}
