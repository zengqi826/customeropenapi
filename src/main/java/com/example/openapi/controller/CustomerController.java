/**
 * 
 */
package com.example.openapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.openapi.model.Address;
import com.example.openapi.model.AddressIdentity;
import com.example.openapi.model.CustomerProfile;
import com.example.openapi.model.Email;
import com.example.openapi.model.EmailIdentity;
import com.example.openapi.model.Phone;
import com.example.openapi.model.PhoneIdentity;
import com.example.openapi.model.request.CustomerAddressUpdateRequest;
import com.example.openapi.model.request.CustomerEmailUpdateRequest;
import com.example.openapi.model.request.CustomerPhoneUpdateRequest;
import com.example.openapi.model.response.CustomerAddressResponse;
import com.example.openapi.model.response.CustomerEmailResponse;
import com.example.openapi.model.response.CustomerParticularsResponse;
import com.example.openapi.model.response.CustomerPhoneResponse;
import com.example.openapi.service.CustomerAddressService;
import com.example.openapi.service.CustomerEmailService;
import com.example.openapi.service.CustomerPhoneService;
import com.example.openapi.service.CustomerProfileService;

/**
 * @author 86211
 *
 */
@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerProfileService customerProfileService;

    @Autowired
    CustomerAddressService customerAddressService;

    @Autowired
    CustomerEmailService customerEmailService;

    @Autowired
    CustomerPhoneService customerPhoneService;

    @RequestMapping(value = "/profiles", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<CustomerProfile> getCustomerProfiles(@RequestHeader String clientId,
            @RequestHeader String uuid, @RequestHeader("Authorization") String authorization) throws Exception {

        HttpHeaders httpHeaders = creatHttpHeaders(uuid, authorization);
        CustomerProfile customerProfiles = customerProfileService.getCustomerProfileByClientId(clientId);

        if (null == customerProfiles) {
            throw new NoHandlerFoundException(RequestMethod.GET.toString(), "/api/v1/customer/profiles", httpHeaders);
        } else {
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(customerProfiles);
        }

    }

    @RequestMapping(value = "/profiles/basic", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<CustomerParticularsResponse> getCustomerPaticulars(@RequestHeader String clientId,
            @RequestHeader String uuid, @RequestHeader("Authorization") String authorization) throws Exception {

        HttpHeaders httpHeaders = creatHttpHeaders(uuid, authorization);
        CustomerProfile customerProfiles = customerProfileService.getCustomerProfileByClientId(clientId);
        if (null == customerProfiles) {
            throw new NoHandlerFoundException(RequestMethod.GET.toString(), "/api/v1/customer/profiles/basic",
                    httpHeaders);
        } else {
            CustomerParticularsResponse customerParticularsResponse = new CustomerParticularsResponse();
            customerParticularsResponse.setCustomerType(customerProfiles.getCustomerType());
            customerParticularsResponse.setCustomerParticulars(customerProfiles.getCustomerParticulars());
            customerParticularsResponse.setCustomerSegment(customerProfiles.getCustomerSegment());
            customerParticularsResponse.setPartnerCustomerSegment(customerProfiles.getPartnerCustomerSegment());
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(customerParticularsResponse);
        }

    }

    @RequestMapping(value = "/profiles/addresses", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<CustomerAddressResponse> getAddresses(@RequestHeader String clientId,
            @RequestHeader String uuid, @RequestHeader("Authorization") String authorization) throws Exception {

        HttpHeaders httpHeaders = creatHttpHeaders(uuid, authorization);
        Optional<List<Address>> addressesList = customerAddressService.getCustomerAddressesByClientId(clientId);

        if (addressesList.isPresent()) {
            List<Address> addresses = addressesList.get();
            CustomerAddressResponse customerAddressResponse = new CustomerAddressResponse();
            customerAddressResponse.setAddressList(addresses);
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(customerAddressResponse);
        } else {
            throw new NoHandlerFoundException(RequestMethod.GET.toString(), "/api/v1/customer/profiles/addresses",
                    httpHeaders);
        }
    }

    @RequestMapping(value = "/profiles/addresses", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<String> updateAddresses(@RequestHeader String clientId, @RequestHeader String uuid,
            @RequestHeader("Authorization") String authorization,
            @RequestBody CustomerAddressUpdateRequest customerAddressUpdateRequest) throws Exception {

        List<Address> addressLists = customerAddressUpdateRequest.getAddress();
        HttpHeaders httpHeaders = creatHttpHeaders(uuid, authorization);
        if (!addressLists.isEmpty()) {
            CustomerProfile customerProfile = customerProfileService.getCustomerProfileByClientId(clientId);
            // TODO post data is the same as data in DB

            addressLists.forEach(address -> {
                AddressIdentity addressIdentity = new AddressIdentity();
                addressIdentity.setAddressKey(address.getAddressKeyForWrite());
                addressIdentity.setClientId(clientId);
                address.setAddressIentity(addressIdentity);
                address.setCustomerProfile(customerProfile);
            });

            customerAddressService.saveAddressesByClientId(addressLists);
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(HttpStatus.OK.toString());
        } else {
            throw new NoHandlerFoundException(RequestMethod.POST.toString(), "/api/v1/customer/profiles/addresses",
                    httpHeaders);
        }
    }

    @RequestMapping(value = "/profiles/emails", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<CustomerEmailResponse> getEmails(@RequestHeader String clientId, @RequestHeader String uuid,
            @RequestHeader("Authorization") String authorization) throws Exception {

        HttpHeaders httpHeaders = creatHttpHeaders(uuid, authorization);
        Optional<List<Email>> addressLists = customerEmailService.getCustomerEmailsByClientId(clientId);

        if (addressLists.isPresent()) {
            List<Email> emails = addressLists.get();
            CustomerEmailResponse customerEmailResponse = new CustomerEmailResponse();
            customerEmailResponse.setEmailList(emails);
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(customerEmailResponse);
        } else {
            throw new NoHandlerFoundException(RequestMethod.GET.toString(), "/api/v1/customer/profiles/emails",
                    httpHeaders);
        }
    }

    @RequestMapping(value = "/profiles/emails", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<String> updateEmails(@RequestHeader String clientId, @RequestHeader String uuid,
            @RequestHeader("Authorization") String authorization,
            @RequestBody CustomerEmailUpdateRequest customerEmailUpdateRequest) throws Exception {

        List<Email> emailsList = customerEmailUpdateRequest.getEmails();
        HttpHeaders httpHeaders = creatHttpHeaders(uuid, authorization);
        if (!emailsList.isEmpty()) {
            CustomerProfile customerProfile = customerProfileService.getCustomerProfileByClientId(clientId);
            // TODO post data is the same as data in DB

            emailsList.forEach(email -> {
                EmailIdentity emailIdentity = new EmailIdentity();
                emailIdentity.setEmailKey(email.getEmailKeyForWrite());
                emailIdentity.setClientId(clientId);
                email.setEmailIdentity(emailIdentity);
                email.setCustomerProfile(customerProfile);
            });

            customerEmailService.saveEmailsByClientId(emailsList);
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(HttpStatus.OK.toString());
        } else {
            throw new NoHandlerFoundException(RequestMethod.POST.toString(), "/api/v1/customer/profiles/emails",
                    httpHeaders);
        }
    }

    @RequestMapping(value = "/profiles/phoneNumbers", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<CustomerPhoneResponse> gePhoneNumbers(@RequestHeader String clientId,
            @RequestHeader String uuid, @RequestHeader("Authorization") String authorization) throws Exception {

        HttpHeaders httpHeaders = creatHttpHeaders(uuid, authorization);
        Optional<List<Phone>> phonesList = customerPhoneService.getCustomerPhonesByClientId(clientId);

        if (phonesList.isPresent()) {
            List<Phone> phones = phonesList.get();
            CustomerPhoneResponse customerPhoneResponse = new CustomerPhoneResponse();
            customerPhoneResponse.setPhoneList(phones);
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(customerPhoneResponse);
        } else {
            throw new NoHandlerFoundException(RequestMethod.GET.toString(), "/api/v1/customer/profiles/phoneNumbers",
                    httpHeaders);
        }
    }

    @RequestMapping(value = "/profiles/phoneNumbers", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<String> updatePhoneNumbers(@RequestHeader String clientId, @RequestHeader String uuid,
            @RequestHeader("Authorization") String authorization,
            @RequestBody CustomerPhoneUpdateRequest customerPhoneUpdateRequest) throws Exception {

        List<Phone> phonesList = customerPhoneUpdateRequest.getPhones();
        HttpHeaders httpHeaders = creatHttpHeaders(uuid, authorization);
        if (!phonesList.isEmpty()) {
            CustomerProfile customerProfile = customerProfileService.getCustomerProfileByClientId(clientId);
            // TODO post data is the same as data in DB

            phonesList.forEach(phone -> {
                PhoneIdentity phoneIdentity = new PhoneIdentity();
                phoneIdentity.setPhoneKeyy(phone.getPhoneKeyForWrite());
                phoneIdentity.setClientId(clientId);
                phone.setPhoneIdentity(phoneIdentity);
                phone.setCustomerProfile(customerProfile);
            });

            customerPhoneService.savePhonesByClientId(phonesList);
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(HttpStatus.OK.toString());
        } else {
            throw new NoHandlerFoundException(RequestMethod.POST.toString(), "/api/v1/customer/profiles/phoneNumbers",
                    httpHeaders);
        }
    }

    @RequestMapping(value = "/profiles/errors", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<String> getErrorResponse(@RequestHeader String clientId, @RequestHeader String uuid,
            @RequestHeader("Authorization") String authorization) throws Exception {

        HttpHeaders httpHeaders = creatHttpHeaders(uuid, authorization);
        throw new Exception(httpHeaders.toString());
    }

    /**
     * @param uuid
     * @param authorization
     * @return
     */
    private HttpHeaders creatHttpHeaders(String uuid, String authorization) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("zq_uuid", uuid);
        httpHeaders.add("uuid", UUID.randomUUID().toString());
        httpHeaders.add("content-type", MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add("mfacode", authorization);
        return httpHeaders;
    }
}
