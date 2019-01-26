/**
 * 
 */
package com.example.openapi.model.exception;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 86211
 *
 */
public class ErrorResponse {

    @ApiModelProperty(required = true, value = "Error code which qualifies the error")
    private String code;

    private String details;

    private String location;

    @ApiModelProperty(required = true, value = "Invalid - Request did not confirm to the specification and was unprocessed and rejected. Please fix the value and try again")
    private TypeEnum type;

    private Object moreInfo;

    /**
     * 
     */
    public ErrorResponse() {
    }

    /**
     * @param code
     * @param type
     */
    public ErrorResponse(String code, TypeEnum type) {
        super();
        this.code = code;
        this.type = type;
    }

    /**
     * @param code
     * @param details
     * @param location
     * @param type
     * @param moreInfo
     */
    public ErrorResponse(String code, String details, String location, TypeEnum type, Object moreInfo) {
        super();
        this.code = code;
        this.details = details;
        this.location = location;
        this.type = type;
        this.moreInfo = moreInfo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Object getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(Object moreInfo) {
        this.moreInfo = moreInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((details == null) ? 0 : details.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((moreInfo == null) ? 0 : moreInfo.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        ErrorResponse other = (ErrorResponse) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (details == null) {
            if (other.details != null)
                return false;
        } else if (!details.equals(other.details))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (moreInfo == null) {
            if (other.moreInfo != null)
                return false;
        } else if (!moreInfo.equals(other.moreInfo))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ErrorResponse [code=" + code + ", details=" + details + ", location=" + location + ", type=" + type
                + ", moreInfo=" + moreInfo + "]";
    }

}
