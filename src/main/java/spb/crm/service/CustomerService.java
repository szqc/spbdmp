package spb.crm.service;

import org.apache.ibatis.annotations.Param;
import spb.crm.domain.Customer;

import java.util.HashMap;
import java.util.List;

public interface CustomerService {
    List<Customer> searchByName(String custName);
    Customer searchByNameAndNo(String custName, String custNo);
    List<Customer> searchCustomer(Customer customer);
    HashMap searchCustomerInfo(Customer customer);
    List<Customer> searchCustomerInfo2(Customer customer);
    List<Customer> searchCustLazyLoad(Customer customer);
    void addCustomer(Customer customer);
    void addCustomer2(Customer customer);
    Customer noBody(String custName);

}
