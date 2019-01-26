/**
 * 
 */
package com.example.openapi.model.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 86211
 *
 */
public class ProviderError implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4926210059858087341L;

    public ProviderError() {
        
    }
    
    /**
     * @param code
     * @param detail
     * @param fieldId
     */
    public ProviderError(String code, String detail, String fieldId) {
        super();
        this.code = code;
        this.detail = detail;
        this.fieldId = fieldId;
    }

    @JsonProperty("Code")
    protected String code;
    
    @JsonProperty("Detail")
    protected String detail;
    
    @JsonProperty("FieldID")
    protected String fieldId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((detail == null) ? 0 : detail.hashCode());
        result = prime * result + ((fieldId == null) ? 0 : fieldId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProviderError other = (ProviderError) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (detail == null) {
            if (other.detail != null)
                return false;
        } else if (!detail.equals(other.detail))
            return false;
        if (fieldId == null) {
            if (other.fieldId != null)
                return false;
        } else if (!fieldId.equals(other.fieldId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProviderError [code=" + code + ", detail=" + detail + ", fieldId=" + fieldId + "]";
    }
    
    

}
