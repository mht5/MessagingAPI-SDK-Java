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
 * Message
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-06T12:04:52.962+11:00")
public class Message {
  @SerializedName("to")
  private String to = null;

  @SerializedName("deliveryStatus")
  private String deliveryStatus = null;

  @SerializedName("messageId")
  private String messageId = null;

  @SerializedName("messageStatusURL")
  private String messageStatusURL = null;

  public Message to(String to) {
    this.to = to;
    return this;
  }

   /**
   * 
   * @return to
  **/
  @ApiModelProperty(required = true, value = "")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Message deliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
    return this;
  }

   /**
   * 
   * @return deliveryStatus
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  public Message messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

   /**
   * 
   * @return messageId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public Message messageStatusURL(String messageStatusURL) {
    this.messageStatusURL = messageStatusURL;
    return this;
  }

   /**
   * 
   * @return messageStatusURL
  **/
  @ApiModelProperty(required = true, value = "")
  public String getMessageStatusURL() {
    return messageStatusURL;
  }

  public void setMessageStatusURL(String messageStatusURL) {
    this.messageStatusURL = messageStatusURL;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Message message = (Message) o;
    return Objects.equals(this.to, message.to) &&
        Objects.equals(this.deliveryStatus, message.deliveryStatus) &&
        Objects.equals(this.messageId, message.messageId) &&
        Objects.equals(this.messageStatusURL, message.messageStatusURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, deliveryStatus, messageId, messageStatusURL);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Message {\n");
    
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    deliveryStatus: ").append(toIndentedString(deliveryStatus)).append("\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    messageStatusURL: ").append(toIndentedString(messageStatusURL)).append("\n");
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
