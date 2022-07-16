package spb.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spb.crm.mapper.CustomerMapper;
import spb.crm.domain.Customer;
import spb.crm.service.CustomerService;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> searchByName(String custName) {
        return customerMapper.searchByName(custName);
    }

    @Override
    public Customer searchByNameAndNo(String custName, String custNo) {
        return customerMapper.searchByNameAndNo(custName,custNo);
    }

    @Override
    public List<Customer> searchCustomer(Customer customer) {
        return customerMapper.searchCustomer(customer);
    }

    @Override
    public HashMap searchCustomerInfo(Customer customer) {
        return customerMapper.searchCustomerInfo(customer);
    }

    @Override
    public List<Customer> searchCustomerInfo2(Customer customer) {
        return customerMapper.searchCustomerInfo2(customer);
    }

    @Override
    public List<Customer> searchCustLazyLoad(Customer customer) {
        //开启了事务后，桶一个事务中，执行了两条一样是sql（中间没有增删改，则没有commit），第二条sql是直接查询一级缓存的。
        customerMapper.searchCustLazyLoad(customer);
        return customerMapper.searchCustLazyLoad(customer);
    }
}
