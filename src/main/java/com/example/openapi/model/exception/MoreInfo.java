/**
 * 
 */
package com.example.openapi.model.exception;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 86211
 *
 */
public class MoreInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1130722683793729481L;

    @JsonProperty("responseCode")
    private String responseCode;
    
    @JsonProperty("providerErrors")
    private List<ProviderError> providerErrors;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<ProviderError> getProviderErrors() {
        return providerErrors;
    }

    public void setProviderErrors(List<ProviderError> providerErrors) {
        this.providerErrors = providerErrors;
    }
    
}
