package spb.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spb.crm.exception.BasicException;
import spb.crm.mapper.CustomerMapper;
import spb.crm.domain.Customer;
import spb.crm.service.CustomerService;
import spb.crm.util.JwtUtils;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerService customerService;

    @Override
    public Customer noBody(String custName) {
        throw  new BasicException("111111","找不到相关记录");
    }



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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addCustomer(Customer customer) {

        customerMapper.addCustomer(customer);
        customer.setCustNo(customer.getCustName());
        customerService.addCustomer2(customer);
        int i = 1 / 0;

    }
    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void addCustomer2(Customer customer) {

        customerMapper.addCustomer(customer);

    }


}
