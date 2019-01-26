/**
 * 
 */
package com.example.openapi.service;

import java.util.List;
import java.util.Optional;

import com.example.openapi.model.Address;

/**
 * @author 86211
 *
 */
public interface CustomerAddressService {

    Optional<List<Address>> getCustomerAddressesByClientId(String clientId);

    void saveAddressesByClientId(List<Address> addressLists);
}
