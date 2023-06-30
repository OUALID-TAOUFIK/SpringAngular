package com.example.SpringAngular.Service;
import com.example.SpringAngular.CustomerRepo.CustomerRepo;
import com.example.SpringAngular.DTO.CustomerDTO;
import com.example.SpringAngular.DTO.CustomerSaveDTO;
import com.example.SpringAngular.DTO.CustomerUpdateDTO;
import com.example.SpringAngular.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService
{
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String addCustomer(CustomerSaveDTO customerSaveDTO)
    {
        Customer customer = new Customer(

                customerSaveDTO.getCustomername(),
                customerSaveDTO.getCustomeraddress(),
                customerSaveDTO.getMobile(),
                customerSaveDTO.getCustomerdebut(),
                customerSaveDTO.getCustomerfin()

        );
        customerRepo.save(customer);
        return customer.getCustomername();
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer a:getCustomers)
        {
            CustomerDTO customerDTO = new CustomerDTO(

                    a.getCustomerid(),
                    a.getCustomername(),
                    a.getCustomeraddress(),
                    a.getMobile(),
                    a.getCustomerdebut(),
                    a.getCustomerfin()
            );
            customerDTOList.add(customerDTO);
        }

        return  customerDTOList;
    }

    @Override
    public String updateCustomers(CustomerUpdateDTO customerUpdateDTO)
    {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerid())) {
            Customer customer = customerRepo.getById(customerUpdateDTO.getCustomerid());


            customer.setCustomername(customerUpdateDTO.getCustomername());
            customer.setCustomeraddress(customerUpdateDTO.getCustomeraddress());
            customer.setMobile(customerUpdateDTO.getMobile());
            customer.setCustomerdebut((customerUpdateDTO.getCustomerdebut()));
            customer.setCustomerfin((customerUpdateDTO.getCustomerfin()));
            customerRepo.save(customer);
        }
        else
        {
            System.out.println("Customer ID do not Exist");
        }

        return null;
    }

    @Override
    public boolean deleteCustomer(int id) {

        if(customerRepo.existsById(id))
        {
            customerRepo.deleteById(id);
        }
        else
        {
            System.out.println("customer id not found");
        }

        return true;
    }
}