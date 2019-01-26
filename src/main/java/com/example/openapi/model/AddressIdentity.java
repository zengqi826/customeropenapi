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
public class AddressIdentity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 9122330313180466740L;

    @JsonIgnore
    @Column(name = "addressKey")
    @NotNull
    private int addressKey;

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


    public int getAddressKey() {
        return addressKey;
    }

    public void setAddressKey(int addressKey) {
        this.addressKey = addressKey;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + addressKey;
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
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
        AddressIdentity other = (AddressIdentity) obj;
        if (addressKey != other.addressKey)
            return false;
        if (clientId == null) {
            if (other.clientId != null)
                return false;
        } else if (!clientId.equals(other.clientId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AddressIdentity [addressKey=" + addressKey + ", clientId=" + clientId + "]";
    }

    
}
