/*
 * Telstra Messaging API
 *  The Telstra SMS Messaging API allows your applications to send and receive SMS text messages from Australia's leading network operator.  It also allows your application to track the delivery status of both sent and received SMS messages. 
 *
 * OpenAPI spec version: 2.2.5
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
 * OAuthRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-03-08T00:36:43.245Z")
public class OAuthRequest {
  @SerializedName("client_id")
  private String clientId = null;

  @SerializedName("client_secret")
  private String clientSecret = null;

  @SerializedName("grant_type")
  private String grantType = null;

  @SerializedName("scopes")
  private String scopes = null;

  public OAuthRequest clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

   /**
   * Client id
   * @return clientId
  **/
  @ApiModelProperty(required = true, value = "Client id")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public OAuthRequest clientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
    return this;
  }

   /**
   * Client secret
   * @return clientSecret
  **/
  @ApiModelProperty(required = true, value = "Client secret")
  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public OAuthRequest grantType(String grantType) {
    this.grantType = grantType;
    return this;
  }

   /**
   * OAuth grant type
   * @return grantType
  **/
  @ApiModelProperty(required = true, value = "OAuth grant type")
  public String getGrantType() {
    return grantType;
  }

  public void setGrantType(String grantType) {
    this.grantType = grantType;
  }

  public OAuthRequest scopes(String scopes) {
    this.scopes = scopes;
    return this;
  }

   /**
   * OAuth scope
   * @return scopes
  **/
  @ApiModelProperty(required = true, value = "OAuth scope")
  public String getScopes() {
    return scopes;
  }

  public void setScopes(String scopes) {
    this.scopes = scopes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OAuthRequest oauthRequest = (OAuthRequest) o;
    return Objects.equals(this.clientId, oauthRequest.clientId) &&
        Objects.equals(this.clientSecret, oauthRequest.clientSecret) &&
        Objects.equals(this.grantType, oauthRequest.grantType) &&
        Objects.equals(this.scopes, oauthRequest.scopes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, clientSecret, grantType, scopes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OAuthRequest {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientSecret: ").append(toIndentedString(clientSecret)).append("\n");
    sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
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

