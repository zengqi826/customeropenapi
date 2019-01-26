/**
 * 
 */
package com.example.openapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.openapi.model.CustomerProfile;
import com.example.openapi.repository.CustomerProfileRepository;
import com.example.openapi.service.CustomerProfileService;

/**
 * @author 86211
 *
 */
@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired CustomerProfileRepository customerProfileRepository;
    /* (non-Javadoc)
     * @see com.example.openapi.service.CustomerProfileService#getCustomerProfileByClientId()
     */
    @Override
    public CustomerProfile getCustomerProfileByClientId(String clientId) {
        return customerProfileRepository.findByClientId(clientId);
    }
    /* (non-Javadoc)
     * @see com.example.openapi.service.CustomerProfileService#saveCustomerProfile(com.example.openapi.model.CustomerProfile)
     */
    @Override
    public CustomerProfile saveCustomerProfile(CustomerProfile customerProfile) {
        return customerProfileRepository.save(customerProfile);
        
    }

}
