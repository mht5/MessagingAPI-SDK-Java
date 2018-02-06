/*
 * Telstra Messaging API
 *  The Telstra SMS Messaging API allows your applications to send and receive SMS text messages from Australia's leading network operator.  It also allows your application to track the delivery status of both sent and received SMS messages. 
 *
 * OpenAPI spec version: 2.2.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.telstra.messaging;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ProvisionNumberRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-06T12:04:52.962+11:00")
public class ProvisionNumberRequest {
  @SerializedName("activeDays")
  private Integer activeDays = null;

  @SerializedName("notifyURL")
  private String notifyURL = null;

  public ProvisionNumberRequest activeDays(Integer activeDays) {
    this.activeDays = activeDays;
    return this;
  }

   /**
   * 
   * @return activeDays
  **/
  @ApiModelProperty(value = "")
  public Integer getActiveDays() {
    return activeDays;
  }

  public void setActiveDays(Integer activeDays) {
    this.activeDays = activeDays;
  }

  public ProvisionNumberRequest notifyURL(String notifyURL) {
    this.notifyURL = notifyURL;
    return this;
  }

   /**
   * 
   * @return notifyURL
  **/
  @ApiModelProperty(value = "")
  public String getNotifyURL() {
    return notifyURL;
  }

  public void setNotifyURL(String notifyURL) {
    this.notifyURL = notifyURL;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionNumberRequest provisionNumberRequest = (ProvisionNumberRequest) o;
    return Objects.equals(this.activeDays, provisionNumberRequest.activeDays) &&
        Objects.equals(this.notifyURL, provisionNumberRequest.notifyURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activeDays, notifyURL);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionNumberRequest {\n");
    
    sb.append("    activeDays: ").append(toIndentedString(activeDays)).append("\n");
    sb.append("    notifyURL: ").append(toIndentedString(notifyURL)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

