/*
 * Copyright (c) 2016 EMC Corporation. All Rights Reserved.
 */
package com.emc.ia.sdk.sip.ingestion.dto;


public class Search extends NamedLinkContainer {
  private String description;
  private boolean nestedSearch;
  private String state;
  private boolean inUse;
  private String aic;
  private String query;

  public Search() {
    setDescription("Default emails search");  //TODO - need to change default description ?
    setNestedSearch(false);
    setState("DRAFT");
    setInUse(false);
    setAic("http://testaic");
    setQuery("http://testquery");
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isNestedSearch() {
    return nestedSearch;
  }

  public final void setNestedSearch(boolean nestedSearch) {
    this.nestedSearch = nestedSearch;
  }

  public String getState() {
    return state;
  }

  public final void setState(String state) {
    this.state = state;
  }

  public boolean isInUse() {
    return inUse;
  }

  public final void setInUse(boolean inUse) {
    this.inUse = inUse;
  }

  public String getAic() {
    return aic;
  }

  public final void setAic(String aic) {
    this.aic = aic;
  }

  public String getQuery() {
    return query;
  }

  public final void setQuery(String query) {
    this.query = query;
  }

}
