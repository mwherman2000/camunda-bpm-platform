package com.camunda.fox.cycle.web.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.camunda.fox.cycle.connector.ConnectorLoginMode;
import com.camunda.fox.cycle.entity.ConnectorConfiguration;

/**
 * Dataobject exposing connector configuration
 * 
 * @author kristin.polenz
 */
public class ConnectorConfigurationDTO {
  
  private Long connectorId;
  private String name;
  private String loginMode;
  private String connectorName;
  private String user;
  private String password;
  private Map<String, String> properties;
  
  private String connectorClass;
  
  public ConnectorConfigurationDTO() {
  }
  
  public ConnectorConfigurationDTO(ConnectorConfiguration connectorConfiguration) {
    this.connectorId = connectorConfiguration.getId();
    this.name = connectorConfiguration.getLabel();
    if (connectorConfiguration.getLoginMode() != null) {
      this.loginMode = connectorConfiguration.getLoginMode().name();
    } else {
      this.loginMode = ConnectorLoginMode.LOGIN_NOT_REQUIRED.name();
    }
    this.connectorName = connectorConfiguration.getLabel();
    this.user = connectorConfiguration.getGlobalUser();
    this.password = connectorConfiguration.getGlobalPassword();
    this.connectorClass = connectorConfiguration.getConnectorClass();
    this.properties = connectorConfiguration.getProperties();
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getConnectorId() {
    return connectorId;
  }

  public void setConnectorId(Long connectorId) {
    this.connectorId = connectorId;
  }
  
  public String getConnectorName() {
    return connectorName;
  }
  
  public void setConnectorName(String connectorName) {
    this.connectorName = connectorName;
  }
  
  public String getConnectorClass() {
    return connectorClass;
  }
  
  public void setConnectorClass(String connectorClass) {
    this.connectorClass = connectorClass;
  }
  
  public String getLoginMode() {
    return loginMode;
  }
  
  public void setLoginMode(String loginMode) {
    this.loginMode = loginMode;
  }
  
  public String getUser() {
    return user;
  }
  
  public void setUser(String user) {
    this.user = user;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public Map<String, String> getProperties() {
    return properties;
  }
  
  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }
  
  /**
   * Wraps a connector configuation as a data object
   * @param connector configuration
   * @return 
   */
  public static ConnectorConfigurationDTO wrap(ConnectorConfiguration connectorConfiguration) {
    return new ConnectorConfigurationDTO(connectorConfiguration);
  }
  
  /**
   * Wraps a list of connector configurations as a list of the respective connector data objects
   * 
   * @param trackers
   * @return 
   */
  public static List<ConnectorConfigurationDTO> wrapAll(List<ConnectorConfiguration> trackers) {
    List<ConnectorConfigurationDTO> dtos = new ArrayList<ConnectorConfigurationDTO>();
    for (ConnectorConfiguration t: trackers) {
      dtos.add(new ConnectorConfigurationDTO(t));
    }
    
    return dtos;
  }  
}
