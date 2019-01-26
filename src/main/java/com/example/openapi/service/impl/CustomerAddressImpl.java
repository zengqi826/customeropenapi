/**
 * 
 */
package com.example.openapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.openapi.model.Address;
import com.example.openapi.repository.CustomerAddressRepository;
import com.example.openapi.service.CustomerAddressService;

/**
 * @author 86211
 *
 */
@Service
public class CustomerAddressImpl implements CustomerAddressService {

    /*
     * (non-Javadoc)
     * 
     * @see com.example.openapi.service.CustomerAddressService#
     * getCustomerAddressesByClientId(java.lang.String)
     */
    @Autowired
    CustomerAddressRepository customerAddressRepository;

    @Override
    public Optional<List<Address>> getCustomerAddressesByClientId(String clientId) {
        return customerAddressRepository.findByClientId(clientId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.example.openapi.service.CustomerAddressService#saveAddresses(java.util.
     * List)
     */
    @Override
    public void saveAddressesByClientId(List<Address> addressLists) {
        customerAddressRepository.saveAll(addressLists);

    }
}
