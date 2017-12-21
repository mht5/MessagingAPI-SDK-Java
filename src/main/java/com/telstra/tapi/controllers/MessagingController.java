/*
 * TelstraMessagingAPILib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.telstra.tapi.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import com.telstra.tapi.*;
import com.telstra.tapi.models.*;
import com.telstra.tapi.exceptions.*;
import com.telstra.tapi.http.client.HttpClient;
import com.telstra.tapi.http.client.HttpContext;
import com.telstra.tapi.http.request.HttpRequest;
import com.telstra.tapi.http.response.HttpResponse;
import com.telstra.tapi.http.response.HttpStringResponse;
import com.telstra.tapi.http.client.APICallBack;
import com.telstra.tapi.controllers.syncwrapper.APICallBackCatcher;

public class MessagingController extends BaseController {    
    //private static variables for the singleton pattern
    private static Object syncObject = new Object();
    private static MessagingController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the MessagingController class 
     */
    public static MessagingController getInstance() {
        synchronized (syncObject) {
            if (null == instance) {
                instance = new MessagingController();
            }
        }
        return instance;
    }

    /**
     * Retrieve SMS Responses
     * @return    Returns the InboundPollResponse response from the API call 
     */
    public InboundPollResponse retrieveSMSResponses(
    ) throws Throwable {
        APICallBackCatcher<InboundPollResponse> callback = new APICallBackCatcher<InboundPollResponse>();
        retrieveSMSResponsesAsync(callback);
        if(!callback.isSuccess())
            throw callback.getError();
        return callback.getResult();
    }

    /**
     * Retrieve SMS Responses
     * @return    Returns the void response from the API call 
     */
    public void retrieveSMSResponsesAsync(
                final APICallBack<InboundPollResponse> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.getBaseUri();
        
        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/messages/sms");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5677417277196003009L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "Authorization", OAuthManager.getInstance().getAuthorizationHeader());
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        //invoke the callback before request if its not null
        if (getHttpCallBack() != null)
        {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();
                            if (_responseCode == 400)
                                throw new ErrorErrorErrorErrorErrorException("Invalid or missing request parameters", _context);

                            if (_responseCode == 401)
                                throw new ErrorErrorErrorErrorErrorException("Invalid or no credentials passed in the request", _context);

                            if (_responseCode == 403)
                                throw new ErrorErrorErrorErrorErrorException("Authorization credentials passed and accepted but account does not have permission", _context);

                            if (_responseCode == 404)
                                throw new ErrorErrorErrorErrorErrorException("The requested URI does not exist", _context);

                            if (_responseCode == 405)
                                throw new ErrorErrorErrorErrorErrorException("The requested resource does not support the supplied verb", _context);

                            if (_responseCode == 415)
                                throw new ErrorErrorErrorErrorErrorException("API does not support the requested content type", _context);

                            if (_responseCode == 422)
                                throw new ErrorErrorErrorErrorErrorException("The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request", _context);

                            if (_responseCode == 501)
                                throw new ErrorErrorErrorErrorErrorException("The HTTP method being used has not yet been implemented for the requested resource", _context);

                            if (_responseCode == 503)
                                throw new ErrorErrorErrorErrorErrorException("The service requested is currently unavailable", _context);

                            if ((_responseCode < 200) || (_responseCode > 208))
                                throw new ErrorErrorErrorErrorErrorException("An internal error occurred when processing the request", _context);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            InboundPollResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<InboundPollResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Send SMS
     * @param    payload    Required parameter: A JSON or XML payload containing the recipient's phone number and text message.  The recipient number should be in the format '04xxxxxxxx' where x is a digit
     * @return    Returns the MessageSentResponse response from the API call 
     */
    public MessageSentResponse createSendSMS(
                final SendSMSRequest payload
    ) throws Throwable {
        APICallBackCatcher<MessageSentResponse> callback = new APICallBackCatcher<MessageSentResponse>();
        createSendSMSAsync(payload, callback);
        if(!callback.isSuccess())
            throw callback.getError();
        return callback.getResult();
    }

    /**
     * Send SMS
     * @param    payload    Required parameter: A JSON or XML payload containing the recipient's phone number and text message.  The recipient number should be in the format '04xxxxxxxx' where x is a digit
     * @return    Returns the void response from the API call 
     */
    public void createSendSMSAsync(
                final SendSMSRequest payload,
                final APICallBack<MessageSentResponse> callBack
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = Configuration.getBaseUri();
        
        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/messages/sms");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4622162075459589547L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "content-type", "application/json" );
                    put( "Authorization", OAuthManager.getInstance().getAuthorizationHeader());
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(payload));

        //invoke the callback before request if its not null
        if (getHttpCallBack() != null)
        {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();
                            if (_responseCode == 400)
                                throw new ErrorErrorErrorErrorErrorException("Invalid or missing request parameters", _context);

                            if (_responseCode == 401)
                                throw new ErrorErrorErrorErrorErrorException("Invalid or no credentials passed in the request", _context);

                            if (_responseCode == 403)
                                throw new ErrorErrorErrorErrorErrorException("Authorization credentials passed and accepted but account does not have permission", _context);

                            if (_responseCode == 404)
                                throw new ErrorErrorErrorErrorErrorException("The requested URI does not exist", _context);

                            if (_responseCode == 405)
                                throw new ErrorErrorErrorErrorErrorException("The requested resource does not support the supplied verb", _context);

                            if (_responseCode == 415)
                                throw new ErrorErrorErrorErrorErrorException("API does not support the requested content type", _context);

                            if (_responseCode == 422)
                                throw new ErrorErrorErrorErrorErrorException("The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request", _context);

                            if (_responseCode == 501)
                                throw new ErrorErrorErrorErrorErrorException("The HTTP method being used has not yet been implemented for the requested resource", _context);

                            if (_responseCode == 503)
                                throw new ErrorErrorErrorErrorErrorException("The service requested is currently unavailable", _context);

                            if ((_responseCode < 200) || (_responseCode > 208))
                                throw new ErrorErrorErrorErrorErrorException("An internal error occurred when processing the request", _context);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            MessageSentResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<MessageSentResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Get SMS Status
     * @param    messageId    Required parameter: Unique identifier of a message - it is the value returned from a previous POST call to https://api.telstra.com/v2/messages/sms
     * @return    Returns the List<OutboundPollResponse> response from the API call 
     */
    public List<OutboundPollResponse> getSMSStatus(
                final String messageId
    ) throws Throwable {
        APICallBackCatcher<List<OutboundPollResponse>> callback = new APICallBackCatcher<List<OutboundPollResponse>>();
        getSMSStatusAsync(messageId, callback);
        if(!callback.isSuccess())
            throw callback.getError();
        return callback.getResult();
    }

    /**
     * Get SMS Status
     * @param    messageId    Required parameter: Unique identifier of a message - it is the value returned from a previous POST call to https://api.telstra.com/v2/messages/sms
     * @return    Returns the void response from the API call 
     */
    public void getSMSStatusAsync(
                final String messageId,
                final APICallBack<List<OutboundPollResponse>> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.getBaseUri();
        
        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/messages/sms/{messageId}/status");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 4731649903329006644L;
            {
                    put( "messageId", messageId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5410451727054439453L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "Authorization", OAuthManager.getInstance().getAuthorizationHeader());
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        //invoke the callback before request if its not null
        if (getHttpCallBack() != null)
        {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();
                            if (_responseCode == 400)
                                throw new ErrorErrorErrorErrorErrorException("Invalid or missing request parameters", _context);

                            if (_responseCode == 401)
                                throw new ErrorErrorErrorErrorErrorException("Invalid or no credentials passed in the request", _context);

                            if (_responseCode == 403)
                                throw new ErrorErrorErrorErrorErrorException("Authorization credentials passed and accepted but account does not have permission", _context);

                            if (_responseCode == 404)
                                throw new ErrorErrorErrorErrorErrorException("The requested URI does not exist", _context);

                            if (_responseCode == 405)
                                throw new ErrorErrorErrorErrorErrorException("The requested resource does not support the supplied verb", _context);

                            if (_responseCode == 415)
                                throw new ErrorErrorErrorErrorErrorException("API does not support the requested content type", _context);

                            if (_responseCode == 422)
                                throw new ErrorErrorErrorErrorErrorException("The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request", _context);

                            if (_responseCode == 501)
                                throw new ErrorErrorErrorErrorErrorException("The HTTP method being used has not yet been implemented for the requested resource", _context);

                            if (_responseCode == 503)
                                throw new ErrorErrorErrorErrorErrorException("The service requested is currently unavailable", _context);

                            if ((_responseCode < 200) || (_responseCode > 208))
                                throw new ErrorErrorErrorErrorErrorException("An internal error occurred when processing the request", _context);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            List<OutboundPollResponse> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<OutboundPollResponse>>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Send MMS
     * @param    body    Required parameter: A JSON or XML payload containing the recipient's phone number and MMS message.The recipient number should be in the format '04xxxxxxxx' where x is a digit
     * @return    Returns the DynamicResponse response from the API call 
     */
    public DynamicResponse createSendMMS(
                final SendMMSRequest body
    ) throws Throwable {
        APICallBackCatcher<DynamicResponse> callback = new APICallBackCatcher<DynamicResponse>();
        createSendMMSAsync(body, callback);
        if(!callback.isSuccess())
            throw callback.getError();
        return callback.getResult();
    }

    /**
     * Send MMS
     * @param    body    Required parameter: A JSON or XML payload containing the recipient's phone number and MMS message.The recipient number should be in the format '04xxxxxxxx' where x is a digit
     * @return    Returns the void response from the API call 
     */
    public void createSendMMSAsync(
                final SendMMSRequest body,
                final APICallBack<DynamicResponse> callBack
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = Configuration.getBaseUri();
        
        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/messages/mms");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5559637462802127230L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "content-type", "application/json" );
                    put( "Authorization", OAuthManager.getInstance().getAuthorizationHeader());
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(body));

        //invoke the callback before request if its not null
        if (getHttpCallBack() != null)
        {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();
                            if (_responseCode == 400)
                                throw new APIException("Invalid or missing request parameters", _context);

                            if (_responseCode == 401)
                                throw new ErrorErrorErrorErrorErrorException("Invalid or no credentials passed in the request", _context);

                            if (_responseCode == 403)
                                throw new ErrorErrorErrorErrorErrorException("Authorization credentials passed and accepted but account does not have permission", _context);

                            if (_responseCode == 404)
                                throw new ErrorErrorErrorErrorErrorException("The requested URI does not exist", _context);

                            if (_responseCode == 405)
                                throw new ErrorErrorErrorErrorErrorException("The requested resource does not support the supplied verb", _context);

                            if (_responseCode == 415)
                                throw new ErrorErrorErrorErrorErrorException("API does not support the requested content type", _context);

                            if (_responseCode == 422)
                                throw new ErrorErrorErrorErrorErrorException("The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request", _context);

                            if (_responseCode == 501)
                                throw new ErrorErrorErrorErrorErrorException("The HTTP method being used has not yet been implemented for the requested resource", _context);

                            if (_responseCode == 503)
                                throw new ErrorErrorErrorErrorErrorException("The service requested is currently unavailable", _context);

                            if ((_responseCode < 200) || (_responseCode > 208))
                                throw new ErrorErrorErrorErrorErrorException("An internal error occurred when processing the request", _context);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            DynamicResponse _result = new DynamicResponse(_response);

                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Get MMS Status
     * @param    messageid    Required parameter: Unique identifier of a message - it is the value returned from a previous POST call to https://api.telstra.com/v2/messages/mms
     * @return    Returns the List<OutboundPollResponse> response from the API call 
     */
    public List<OutboundPollResponse> getMMSStatus(
                final String messageid
    ) throws Throwable {
        APICallBackCatcher<List<OutboundPollResponse>> callback = new APICallBackCatcher<List<OutboundPollResponse>>();
        getMMSStatusAsync(messageid, callback);
        if(!callback.isSuccess())
            throw callback.getError();
        return callback.getResult();
    }

    /**
     * Get MMS Status
     * @param    messageid    Required parameter: Unique identifier of a message - it is the value returned from a previous POST call to https://api.telstra.com/v2/messages/mms
     * @return    Returns the void response from the API call 
     */
    public void getMMSStatusAsync(
                final String messageid,
                final APICallBack<List<OutboundPollResponse>> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.getBaseUri();
        
        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/messages/mms/{messageid}/status");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5384416980960678478L;
            {
                    put( "messageid", messageid );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5362967240397977531L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "Authorization", OAuthManager.getInstance().getAuthorizationHeader());
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        //invoke the callback before request if its not null
        if (getHttpCallBack() != null)
        {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();
                            if (_responseCode == 400)
                                throw new ErrorErrorErrorErrorErrorException("Invalid or missing request parameters", _context);

                            if (_responseCode == 401)
                                throw new ErrorErrorErrorErrorErrorException("Invalid or no credentials passed in the request", _context);

                            if (_responseCode == 403)
                                throw new ErrorErrorErrorErrorErrorException("Authorization credentials passed and accepted but account does not have permission", _context);

                            if (_responseCode == 404)
                                throw new ErrorErrorErrorErrorErrorException("The requested URI does not exist", _context);

                            if (_responseCode == 405)
                                throw new ErrorErrorErrorErrorErrorException("The requested resource does not support the supplied verb", _context);

                            if (_responseCode == 415)
                                throw new ErrorErrorErrorErrorErrorException("API does not support the requested content type", _context);

                            if (_responseCode == 422)
                                throw new ErrorErrorErrorErrorErrorException("The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request", _context);

                            if (_responseCode == 501)
                                throw new ErrorErrorErrorErrorErrorException("The HTTP method being used has not yet been implemented for the requested resource", _context);

                            if (_responseCode == 503)
                                throw new ErrorErrorErrorErrorErrorException("The service requested is currently unavailable", _context);

                            if ((_responseCode < 200) || (_responseCode > 208))
                                throw new ErrorErrorErrorErrorErrorException("An internal error occurred when processing the request", _context);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            List<OutboundPollResponse> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<OutboundPollResponse>>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

}