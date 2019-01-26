/**
 * 
 */
package com.example.openapi.model.response;

import java.io.Serializable;
import java.util.List;

import com.example.openapi.model.Email;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 86211
 *
 */
public class CustomerEmailResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8502958031083761195L;
    /**
     * 
     */
    @JsonProperty("emails")
    private List<Email> emailList;

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((emailList == null) ? 0 : emailList.hashCode());
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
        CustomerEmailResponse other = (CustomerEmailResponse) obj;
        if (emailList == null) {
            if (other.emailList != null)
                return false;
        } else if (!emailList.equals(other.emailList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerEmailResponse [emailList=" + emailList + "]";
    }
}
