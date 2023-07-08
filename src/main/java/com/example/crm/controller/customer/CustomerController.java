package com.example.crm.controller.customer;

import com.example.crm.domain.customer.Customer;
import com.example.crm.dto.customer.CustomerRegisterDto;
import com.example.crm.dto.customer.CustomerShowDto;
import com.example.crm.service.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService cu) {
        this.customerService = cu;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showCustomerList(Model model) {
        model.addAttribute("data", customerService
                .readAll().map(CustomerShowDto::new).collect(Collectors.toList()));
        return "customer/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String showCustomerForm(Model model) {
        model.addAttribute("registerDto", new CustomerRegisterDto());
        return "customer/add";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCustomer(
            @Valid
            @ModelAttribute("registerDto")
            CustomerRegisterDto registerDto,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "customer/add";
        }
        customerService.create(new Customer(registerDto.getFirstName(), registerDto.getLastName(), registerDto.getNumber()));
        return "redirect:/app/customer";
    }
    @GetMapping("/edit/{id}")
    public String editCustomer(
            @PathVariable Integer id,
            Model model
    ) {
        //FIXME get from database
        model.addAttribute("registerDto", new CustomerRegisterDto());
        return "customer/add";
    }


}
