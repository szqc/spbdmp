package spb.crm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import spb.crm.domain.Customer;

import java.util.HashMap;
import java.util.List;

@Repository
public interface CustomerMapper {

    List<Customer> searchByName(@Param("cust_name") String custName);
    Customer searchByNameAndNo(@Param("cust_name") String custName,@Param("cust_no") String custNo);
    List<Customer> searchCustomer(Customer customer);
    HashMap searchCustomerInfo(Customer customer);
    List<Customer> searchCustomerInfo2(Customer customer);
    List<Customer> searchCustLazyLoad(Customer customer);
}
