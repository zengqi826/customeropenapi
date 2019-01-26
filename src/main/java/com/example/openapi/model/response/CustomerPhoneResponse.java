/**
 * 
 */
package com.example.openapi.model.response;

import java.io.Serializable;
import java.util.List;

import com.example.openapi.model.Phone;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 86211
 *
 */
public class CustomerPhoneResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8074964631074277438L;
    
    @JsonProperty("phones")
    private List<Phone> phoneList;

    @Override
    public String toString() {
        return "CustomerPhoneResponse [phoneList=" + phoneList + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((phoneList == null) ? 0 : phoneList.hashCode());
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
        CustomerPhoneResponse other = (CustomerPhoneResponse) obj;
        if (phoneList == null) {
            if (other.phoneList != null)
                return false;
        } else if (!phoneList.equals(other.phoneList))
            return false;
        return true;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}
