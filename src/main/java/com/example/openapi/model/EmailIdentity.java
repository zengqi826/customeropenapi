/**
 * 
 */
package com.example.openapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 86211
 *
 */
@Embeddable
public class EmailIdentity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -6858352733338144143L;

    /**
     * 
     */

    @NotNull
    @ApiModelProperty(required = true, value = "Unique identifier of the email address")
    @JsonIgnore
    @Column(name = "emailKey")
    private int emailKey;
    
    @JsonIgnore
    @Column(name = "clientId")
    @NotNull
    private String clientId;
    
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getEmailKey() {
        return emailKey;
    }

    public void setEmailKey(int emailKey) {
        this.emailKey = emailKey;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
        result = prime * result + emailKey;
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
        EmailIdentity other = (EmailIdentity) obj;
        if (clientId == null) {
            if (other.clientId != null)
                return false;
        } else if (!clientId.equals(other.clientId))
            return false;
        if (emailKey != other.emailKey)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "EmailIdentity [emailKey=" + emailKey + ", clientId=" + clientId + "]";
    }


    
}
