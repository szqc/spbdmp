package spb.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spb.crm.domain.Customer;
import spb.crm.exception.BasicException;
import spb.crm.service.CustomerService;
import spb.crm.util.JsonData;
import spb.crm.util.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("login")
    public JsonData login(@RequestBody Customer customer) throws Exception{
        Customer c = customerService.searchByNameAndNo(customer.getCustName(), customer.getCustNo());
        if(c == null){
            throw new BasicException("999999","登录失败");
        }else {
            String token = JwtUtils.getJsonWebToken(c);
            return new JsonData(token,"000000",true,"登录成功");
        }
    }
    @RequestMapping("searchByName")
    public JsonData searchByName(@RequestBody Customer customer) {
        System.out.println("=======custName====="+customer.getCustName());
        return new JsonData(customerService.searchByName(customer.getCustName()),"000000",true,"查询成功");
    }
    @RequestMapping("searchByName2")
    public JsonData searchByName2(String custName) {
        System.out.println("=====searchByName2==custName====="+custName);
        return new JsonData(customerService.searchByName(custName),"000000",true,"查询成功");
    }
    @RequestMapping("noBody")
    public JsonData noBody(@RequestBody Customer customer) throws Exception{
        return new JsonData(customerService.noBody(customer.getCustName()),
                "000000",true,"查询成功");
    }



    @RequestMapping("searchByNameAndNo")
    public Customer searchByNameAndNo(String custName, String custNo) {
        return customerService.searchByNameAndNo(custName,custNo);
    }
    @RequestMapping("searchCustomer")
    public JsonData searchCustomer(@RequestBody Customer customer) {
        System.out.println("------customer.getCustName->"+customer.getCustName());
        return new JsonData(customerService.searchCustomer(customer),"000000",true,"查询成功");
    }

    @RequestMapping("searchCustomerInfo")
    public JsonData searchCustomerInfo(@RequestBody Customer customer) {
        System.out.println("------customer.getCustName->"+customer.getCustName());
        return new JsonData(customerService.searchCustomerInfo(customer),"000000",true,"查询成功");
    }

    @RequestMapping("searchCustomerInfo2")
    public JsonData searchCustomerInfo2(@RequestBody Customer customer) {
        System.out.println("------customer.getCustName->"+customer.getCustName());
        return new JsonData(customerService.searchCustomerInfo2(customer),"000000",true,"查询成功");
    }
    @RequestMapping("searchCustomerCourse")
    public JsonData searchCustomerCourse(@RequestBody Customer customer) {
        System.out.println("------customer.getCustName->"+customer.getCustName());
        return new JsonData(customerService.searchCustomerInfo2(customer),"000000",true,"查询成功");
    }


    @RequestMapping("lazyLoad")
    public JsonData searchCustLazyLoad(@RequestBody Customer customer) {
        System.out.println("----1111--customer.getCustName->"+customer.getCustName());
        return new JsonData(customerService.searchCustLazyLoad(customer),"000000",true,"查询成功");
    }

    @RequestMapping("addCustomer")
    public JsonData addCustomer(@RequestBody Customer customer) {

        customer.setCustNo("006");
        customer.setCustName("涂山雨");
        customerService.addCustomer(customer);

        return new JsonData(null,"000000",true,"查询成功");
    }


}
