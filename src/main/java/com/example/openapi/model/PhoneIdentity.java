/**
 * 
 */
package com.example.openapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author 86211
 *
 */
@Embeddable
public class PhoneIdentity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 2838687550122892876L;

    /**
     * 
     */

    @JsonIgnore
    @Column(name = "phoneKey")
    @NotNull
    private int phoneKey;

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


    public int getPhoneKey() {
        return phoneKey;
    }

    public void setPhoneKeyy(int phoneKey) {
        this.phoneKey = phoneKey;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
        result = prime * result + phoneKey;
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
        PhoneIdentity other = (PhoneIdentity) obj;
        if (clientId == null) {
            if (other.clientId != null)
                return false;
        } else if (!clientId.equals(other.clientId))
            return false;
        if (phoneKey != other.phoneKey)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PhoneIdentity [phoneKey=" + phoneKey + ", clientId=" + clientId + "]";
    }


    
}
