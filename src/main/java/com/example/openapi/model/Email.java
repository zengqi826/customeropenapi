/**
 * 
 */
package com.example.openapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 86211
 *
 */
@Entity
@Table(name = "CUSTOMER_EMAIL")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Email implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -6371829889101536366L;

    @EmbeddedId
    @JsonIgnore
    private EmailIdentity emailIdentity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", referencedColumnName = "clientId", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private CustomerProfile customerProfile;

    @NotNull
    @ApiModelProperty(required = true, value = "Updated email address of the customer")
    @JsonProperty("emailAddress")
    @Column(name = "emailAddress")
    private String emailAddress;

    @NotNull
    @ApiModelProperty(required = true, value = "Flag to indicate the preferred email")
    @JsonProperty("preferredEmailFlag")
    @Column(name = "preferredEmailFlag")
    private boolean preferredEmailFlag;

    @JsonProperty(value = "emailKey", access = Access.WRITE_ONLY)
    @Transient
    private int emailKeyForWrite;

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isPreferredEmailFlag() {
        return preferredEmailFlag;
    }

    public void setPreferredEmailFlag(boolean preferredEmailFlag) {
        this.preferredEmailFlag = preferredEmailFlag;
    }

    public int getEmailKeyForWrite() {
        return emailKeyForWrite;
    }

    public void setEmailKeyForWrite(int emailKeyForWrite) {
        this.emailKeyForWrite = emailKeyForWrite;
    }

    public EmailIdentity getEmailIdentity() {
        return emailIdentity;
    }

    public void setEmailIdentity(EmailIdentity emailIdentity) {
        this.emailIdentity = emailIdentity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerProfile == null) ? 0 : customerProfile.hashCode());
        result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
        result = prime * result + ((emailIdentity == null) ? 0 : emailIdentity.hashCode());
        result = prime * result + (preferredEmailFlag ? 1231 : 1237);
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
        Email other = (Email) obj;
        if (customerProfile == null) {
            if (other.customerProfile != null)
                return false;
        } else if (!customerProfile.equals(other.customerProfile))
            return false;
        if (emailAddress == null) {
            if (other.emailAddress != null)
                return false;
        } else if (!emailAddress.equals(other.emailAddress))
            return false;
        if (emailIdentity == null) {
            if (other.emailIdentity != null)
                return false;
        } else if (!emailIdentity.equals(other.emailIdentity))
            return false;
        if (preferredEmailFlag != other.preferredEmailFlag)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Email [emailIdentity=" + emailIdentity + ", customerProfile=" + customerProfile + ", emailAddress="
                + emailAddress + ", preferredEmailFlag=" + preferredEmailFlag + "]";
    }
    
    @JsonProperty(value = "emailKey", access = Access.READ_ONLY)
    public int getEmaiKey() {
        return emailIdentity.getEmailKey();
    }


}
