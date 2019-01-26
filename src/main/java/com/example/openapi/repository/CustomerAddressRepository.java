/**
 * 
 */
package com.example.openapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.openapi.model.Address;
import com.example.openapi.model.AddressIdentity;

/**
 * @author 86211
 *
 */
public interface CustomerAddressRepository extends JpaRepository<Address, AddressIdentity> {

    @Query(value="select * FROM customer_address WHERE CLIENT_ID=?1" ,nativeQuery=true)
    Optional<List<Address>> findByClientId(String clientId);
    
}
