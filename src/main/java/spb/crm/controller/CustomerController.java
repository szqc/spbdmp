package spb.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spb.crm.domain.Customer;
import spb.crm.service.CustomerService;
import spb.crm.util.JsonData;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("searchByName")
    public JsonData searchByName(@RequestBody Customer customer) {
        System.out.println("=======custName====="+customer.getCustName());
        return new JsonData(customerService.searchByName(customer.getCustName()),true,"查询成功");
    }

    @RequestMapping("searchByNameAndNo")
    public Customer searchByNameAndNo(String custName, String custNo) {
        return customerService.searchByNameAndNo(custName,custNo);
    }
    @RequestMapping("searchCustomer")
    public JsonData searchCustomer(@RequestBody Customer customer) {
        System.out.println("------customer.getCustName->"+customer.getCustName());
        return new JsonData(customerService.searchCustomer(customer),true,"查询成功");
    }

    @RequestMapping("searchCustomerInfo")
    public JsonData searchCustomerInfo(@RequestBody Customer customer) {
        System.out.println("------customer.getCustName->"+customer.getCustName());
        return new JsonData(customerService.searchCustomerInfo(customer),true,"查询成功");
    }

    @RequestMapping("searchCustomerInfo2")
    public JsonData searchCustomerInfo2(@RequestBody Customer customer) {
        System.out.println("------customer.getCustName->"+customer.getCustName());
        return new JsonData(customerService.searchCustomerInfo2(customer),true,"查询成功");
    }
    @RequestMapping("lazyLoad")
    public JsonData searchCustLazyLoad(@RequestBody Customer customer) {
        System.out.println("----1111--customer.getCustName->"+customer.getCustName());
        return new JsonData(customerService.searchCustLazyLoad(customer),true,"查询成功");
    }


}
