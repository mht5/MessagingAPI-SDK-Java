/*
 * Telstra Messaging API
 *  # Introduction  Send and receive SMS and MMS messages globally using Telstraâ€™s enterprise grade Messaging API. It also allows your application to track the delivery status of both sent and received messages. Get your dedicated Australian number, and start sending and receiving messages today.  # Features  The Telstra Messaging API provides the features below. | Feature | Description | | --- | --- | | `Dedicated Number` | Provision a mobile number for your account to be used as `from` address in the API | | `Send Messages` | Sending SMS or MMS messages | | `Receive Messages` | Telstra will deliver messages sent to a dedicated number or to the `notifyURL` defined by you | | `Broadcast Messages` | Invoke a single API call to send a message to a list of numbers provided in `to` | | `Delivery Status` | Query the delivery status of your messages | | `Callbacks` | Provide a notification URL and Telstra will notify your app when a message status changes | | `Alphanumeric Identifier` | Differentiate yourself by providing an alphanumeric string in `from`. This feature is only available on paid plans | | `Concatenation` | Send messages up to 1900 characters long and Telstra will automaticaly segment and reassemble them | | `Reply Request` | Create a chat session by associating `messageId` and `to` number to track responses received from a mobile number. We will store this association for 8 days | | `Character set` | Accepts all Unicode characters as part of UTF-8 | | `Bounce-back response` | See if your SMS hits an unreachable or unallocated number (Australia Only) | | `Queuing` | Messaging API will automatically queue and deliver each message at a compliant rate. | | `Emoji Encoding` | The API supports the encoding of the full range of emojis. Emojis in the reply messages will be in their UTF-8 format. |  ## Delivery Notification or Callbacks  The API provides several methods for notifying when a message has been delivered to the destination.  1. When you send a message there is an opportunity to specify a `notifyURL`. Once the message has been delivered the API will make a call to this URL to advise of the message status. 2. If you do not specify a URL you can always call the `GET /status` API to get the status of the message.  # Getting Access to the API  1. Register at [https://dev.telstra.com](https://dev.telstra.com). 2. After registration, login to [https://dev.telstra.com](https://dev.telstra.com) and navigate to the **My apps** page. 3. Create your application by clicking the **Add new app** button 4. Select **API Free Trial** Product when configuring your application. This Product includes the Telstra Messaging API as well as other free trial APIs. Your application will be approved automatically. 5. There is a maximum of 1000 free messages per developer. Additional messages and features can be purchased from [https://dev.telstra.com](https://dev.telstra.com). 6. Note your `Client key` and `Client secret` as these will be needed to provision a number for your application and for authentication.  Now head over to **Getting Started** where you can find a postman collection as well as some links to sample apps and SDKs to get you started. Happy Messaging!  # Frequently Asked Questions  **Q: Is creating a subscription via the Provisioning call a required step?** A. Yes. You will only be able to start sending messages if you have a provisioned dedicated number. Use Provisioning to create a dedicated number subscription, or renew your dedicated number if it has expired.  **Q: When trying to send an SMS I receive a `400 Bad Request` response. How can I fix this?** A. You need to make sure you have a provisioned dedicated number before you can send an SMS.  If you do not have a provisioned dedicated number and you try to send a message via the API, you will get the error below in the response:  <pre><code class=\"language-sh\">{   \"status\":\"400\",   \"code\":\"DELIVERY-IMPOSSIBLE\",   \"message\":\"Invalid \\'from\\' address specified\" }</code></pre>  Use Provisioning to create a dedicated number subscription, or renew your dedicated number if it has expired.  **Q: How long does my dedicated number stay active for?** A. When you provision a dedicated number, by default it will be active for 30-days. You can use the `activeDays` parameter during the provisioning call to increment or decrement the number of days your dedicated number will remain active.  **Q: Can I send a broadcast message using the Telstra Messaging API?** A. Yes. Recipient numbers can be in the form of an array of strings if a broadcast message needs to be sent, allowing you to send to multiple mobile numbers in one API call.   A sample request body for this will be: `{\"to\":[\"+61412345678\",\"+61487654321\"],\"body\":\"Test Message\"}`  **Q: Can I use `Alphanumeric Identifier` from my paid plan via credit card?** A. `Alphanumeric Identifier` is only available on Telstra Account paid plans, not through credit card paid plans.  **Q: What is the maximum sized MMS that I can send?** A. This will depend on the carrier that will receive the MMS. For Telstra it's up to 2MB,  Optus up to 1.5MB and Vodafone only allows up to 500kB. You will need to check with international carriers for thier MMS size limits.  **Q: How is the size of an MMS calculated?** A. Images are scaled up to approximately 4/3 when base64 encoded. Additionally, there is approximately 200 bytes of overhead on each MMS. Assuming the maximum MMS that can be sent on Telstraâ€™s network is 2MB, then the maximum image size that can be sent will be approximately 1.378MB (1.378 x 1.34 + 200, without SOAP encapsulation).  **Q: How is an MMS classified as Small or Large?** A. MMSes with size below 600kB are classed as Small whereas those that are bigger than 600kB are classed as Large. They will be charged accordingly.  **Q: Are SMILs supported by the Messaging API?** A. While there will be no error if you send an MMS with a SMIL presentation, the actual layout or sequence defined in the SMIL may not display as expected because most of the new smartphone devices ignore the SMIL presentation layer. SMIL was used in feature phones which had limited capability and SMIL allowed a *powerpoint type* presentation to be provided. Smartphones now have the capability to display video which is the better option for presentations. It is recommended that MMS messages should just drop the SMIL.  **Q: How do I assign a delivery notification or callback URL?** A. You can assign a delivery notification or callback URL by adding the `notifyURL` parameter in the body of the request when you send a message. Once the message has been delivered, a notification will then be posted to this callback URL.  **Q: What is the difference between the `notifyURL` parameter in the Provisoning call versus the `notifyURL` parameter in the Send Message call?** A. The `notifyURL` in the Provisoning call will be the URL where replies to the provisioned number will be posted. On the other hand, the `notifyURL` in the Send Message call will be the URL where the delivery notification will be posted, e.g. when an SMS has already been delivered to the recipient.  # Getting Started  Below are the steps to get started with the Telstra Messaging API.   1. Generate an OAuth2 token using your `Client key` and `Client secret`.   2. Use the Provisioning call to create a subscription and receive a dedicated number.   3. Send a message to a specific mobile number.  ## Run in Postman <a href=\"https://app.getpostman.com/run-collection/ded00578f69a9deba256#?env%5BMessaging%20API%20Environments%5D=W3siZW5hYmxlZCI6dHJ1ZSwia2V5IjoiY2xpZW50X2lkIiwidmFsdWUiOiIiLCJ0eXBlIjoidGV4dCJ9LHsiZW5hYmxlZCI6dHJ1ZSwia2V5IjoiY2xpZW50X3NlY3JldCIsInZhbHVlIjoiIiwidHlwZSI6InRleHQifSx7ImVuYWJsZWQiOnRydWUsImtleSI6ImFjY2Vzc190b2tlbiIsInZhbHVlIjoiIiwidHlwZSI6InRleHQifSx7ImVuYWJsZWQiOnRydWUsImtleSI6Imhvc3QiLCJ2YWx1ZSI6InRhcGkudGVsc3RyYS5jb20iLCJ0eXBlIjoidGV4dCJ9LHsiZW5hYmxlZCI6dHJ1ZSwia2V5IjoiQXV0aG9yaXphdGlvbiIsInZhbHVlIjoiIiwidHlwZSI6InRleHQifSx7ImVuYWJsZWQiOnRydWUsImtleSI6Im9hdXRoX2hvc3QiLCJ2YWx1ZSI6InNhcGkudGVsc3RyYS5jb20iLCJ0eXBlIjoidGV4dCJ9LHsiZW5hYmxlZCI6dHJ1ZSwia2V5IjoibWVzc2FnZV9pZCIsInZhbHVlIjoiIiwidHlwZSI6InRleHQifV0=\"><img src=\"https://run.pstmn.io/button.svg\" alt=\"Run in Postman\"/></a>  ## Sample Apps   - [Perl Sample App](https://github.com/telstra/MessagingAPI-perl-sample-app)   - [Happy Chat App](https://github.com/telstra/messaging-sample-code-happy-chat)   - [PHP Sample App](https://github.com/developersteve/telstra-messaging-php)  ## SDK Repos   - [Messaging API - PHP SDK](https://github.com/telstra/MessagingAPI-SDK-php)   - [Messaging API - Python SDK](https://github.com/telstra/MessagingAPI-SDK-python)   - [Messaging API - Ruby SDK](https://github.com/telstra/MessagingAPI-SDK-ruby)   - [Messaging API - NodeJS SDK](https://github.com/telstra/MessagingAPI-SDK-node)   - [Messaging API - .Net2 SDK](https://github.com/telstra/MessagingAPI-SDK-dotnet)   - [Messaging API - Java SDK](https://github.com/telstra/MessagingAPI-SDK-Java)  ## Blog Posts For more information on the Messaging API, you can read these blog posts: - [Callbacks Part 1](https://dev.telstra.com/content/understanding-messaging-api-callbacks-part-1)  - [Callbacks Part 2](https://dev.telstra.com/content/understanding-messaging-api-callbacks-part-2) 
 *
 * OpenAPI spec version: 2.2.7
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.telstra.messaging;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.telstra.ApiCallback;
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.ApiResponse;
import com.telstra.Configuration;
import com.telstra.Pair;
import com.telstra.ProgressRequestBody;
import com.telstra.ProgressResponseBody;

public class AuthenticationApi {
    private ApiClient apiClient;

    public AuthenticationApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AuthenticationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for authToken
     * @param clientId  (required)
     * @param clientSecret  (required)
     * @param grantType  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public okhttp3.Call authTokenCall(String clientId, String clientSecret, String grantType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/oauth/token";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (clientId != null)
        localVarFormParams.put("client_id", clientId);
        if (clientSecret != null)
        localVarFormParams.put("client_secret", clientSecret);
        if (grantType != null)
        localVarFormParams.put("grant_type", grantType);

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/x-www-form-urlencoded"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    private okhttp3.Call authTokenValidateBeforeCall(String clientId, String clientSecret, String grantType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'clientId' is set
        if (clientId == null) {
            throw new ApiException("Missing the required parameter 'clientId' when calling authToken(Async)");
        }
        
        // verify the required parameter 'clientSecret' is set
        if (clientSecret == null) {
            throw new ApiException("Missing the required parameter 'clientSecret' when calling authToken(Async)");
        }
        
        // verify the required parameter 'grantType' is set
        if (grantType == null) {
            throw new ApiException("Missing the required parameter 'grantType' when calling authToken(Async)");
        }
        

        okhttp3.Call call = authTokenCall(clientId, clientSecret, grantType, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Generate OAuth2 token
     * To generate an OAuth2 Authentication token, pass through your &#x60;Client key&#x60; and &#x60;Client secret&#x60; that you received when you registered for the **API Free Trial** Product. The grant_type should be left as &#x60;client_credentials&#x60; and the scope as &#x60;NSMS&#x60;. The token will expire in one hour. 
     * @param clientId  (required)
     * @param clientSecret  (required)
     * @param grantType  (required)
     * @return OAuthResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OAuthResponse authToken(String clientId, String clientSecret, String grantType) throws ApiException {
        ApiResponse<OAuthResponse> resp = authTokenWithHttpInfo(clientId, clientSecret, grantType);
        return resp.getData();
    }

    /**
     * Generate OAuth2 token
     * To generate an OAuth2 Authentication token, pass through your &#x60;Client key&#x60; and &#x60;Client secret&#x60; that you received when you registered for the **API Free Trial** Product. The grant_type should be left as &#x60;client_credentials&#x60; and the scope as &#x60;NSMS&#x60;. The token will expire in one hour. 
     * @param clientId  (required)
     * @param clientSecret  (required)
     * @param grantType  (required)
     * @return ApiResponse&lt;OAuthResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<OAuthResponse> authTokenWithHttpInfo(String clientId, String clientSecret, String grantType) throws ApiException {
        okhttp3.Call call = authTokenValidateBeforeCall(clientId, clientSecret, grantType, null, null);
        Type localVarReturnType = new TypeToken<OAuthResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Generate OAuth2 token (asynchronously)
     * To generate an OAuth2 Authentication token, pass through your &#x60;Client key&#x60; and &#x60;Client secret&#x60; that you received when you registered for the **API Free Trial** Product. The grant_type should be left as &#x60;client_credentials&#x60; and the scope as &#x60;NSMS&#x60;. The token will expire in one hour. 
     * @param clientId  (required)
     * @param clientSecret  (required)
     * @param grantType  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call authTokenAsync(String clientId, String clientSecret, String grantType, final ApiCallback<OAuthResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        okhttp3.Call call = authTokenValidateBeforeCall(clientId, clientSecret, grantType, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OAuthResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
