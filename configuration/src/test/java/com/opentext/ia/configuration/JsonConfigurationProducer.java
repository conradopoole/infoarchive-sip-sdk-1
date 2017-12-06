/*
 * Copyright (c) 2016-2017 by OpenText Corporation. All Rights Reserved.
 */
package com.opentext.ia.configuration;

import java.util.Collections;
import java.util.List;

import com.opentext.ia.configuration.JsonConfigurationProducer.JsonConfiguration;


public class JsonConfigurationProducer implements ConfigurationProducer<JsonConfiguration> {

  @Override
  public JsonConfiguration produce(ConfigurationObject container) {
    return new JsonConfiguration(container);
  }


  public static class JsonConfiguration implements Configuration<ConfigurationObject> {

    private final ConfigurationObject container;

    public JsonConfiguration(ConfigurationObject container) {
      this.container = container;
    }

    @Override
    public String toString() {
      return container.toString();
    }

    @Override
    public List<ConfigurationObject> getTenants() {
      return childrenOf(container, "tenants");
    }

    private List<ConfigurationObject> childrenOf(ConfigurationObject parent, String collection) {
      return parent.getChildObjects().computeIfAbsent(collection, ignored -> Collections.emptyList());
    }

    @Override
    public List<ConfigurationObject> getApplications(ConfigurationObject tenant) {
      return childrenOf(tenant, "applications");
    }

    @Override
    public List<ConfigurationObject> getSearches(ConfigurationObject application) {
      return childrenOf(application, "searches");
    }

    @Override
    public List<ConfigurationObject> getFileSystemRoots() {
      return childrenOf(container, "fileSystemRoots");
    }

    @Override
    public List<ConfigurationObject> getSpaces(ConfigurationObject application) {
      return childrenOf(application, "spaces");
    }

    @Override
    public List<ConfigurationObject> getSpaceRootFolders(ConfigurationObject space) {
      return childrenOf(space, "spaceRootFolders");
    }

    @Override
    public List<ConfigurationObject> getSpaceRootXdbLibraries(ConfigurationObject space) {
      return childrenOf(space, "spaceRootXdbLibraries");
    }

    @Override
    public List<ConfigurationObject> getXdbLibraries(ConfigurationObject spaceRootXdbLibrary) {
      return childrenOf(spaceRootXdbLibrary, "xdbLibraries");
    }

    @Override
    public List<ConfigurationObject> getPdiSchemas(ConfigurationObject application) {
      return childrenOf(application, "pdiSchemas");
    }

    @Override
    public List<ConfigurationObject> getHoldings(ConfigurationObject application) {
      return childrenOf(application, "holdings");
    }

    @Override
    public List<ConfigurationObject> getCryptoObjects() {
      return childrenOf(container, "cryptoObjects");
    }

    @Override
    public List<ConfigurationObject> getXdbFederations() {
      return childrenOf(container, "xdbFederations");
    }

  }

}
