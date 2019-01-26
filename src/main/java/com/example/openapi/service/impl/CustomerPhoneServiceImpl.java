/**
 * 
 */
package com.example.openapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.openapi.model.Phone;
import com.example.openapi.repository.CustomerPhoneRepository;
import com.example.openapi.service.CustomerPhoneService;

/**
 * @author 86211
 *
 */
@Service
public class CustomerPhoneServiceImpl implements CustomerPhoneService {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.example.openapi.service.CustomerPhoneService#getCustomerPhonesByClientId(
     * java.lang.String)
     */
    @Autowired
    CustomerPhoneRepository customerPhoneRepository;

    @Override
    public Optional<List<Phone>> getCustomerPhonesByClientId(String clientId) {
        return customerPhoneRepository.findByClientId(clientId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.example.openapi.service.CustomerPhoneService#savePhonesByClientId(java.
     * util.List)
     */
    @Override
    public void savePhonesByClientId(List<Phone> phonesList) {
        customerPhoneRepository.saveAll(phonesList);

    }

}
