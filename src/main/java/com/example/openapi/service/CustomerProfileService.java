/**
 * 
 */
package com.example.openapi.service;

import com.example.openapi.model.CustomerProfile;

/**
 * @author 86211
 *
 */
public interface CustomerProfileService {

    CustomerProfile getCustomerProfileByClientId(String clientId);
    CustomerProfile saveCustomerProfile(CustomerProfile customerProfile);
}
