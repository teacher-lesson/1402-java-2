package com.example.crm.dto.customer;

import com.example.crm.domain.customer.Customer;
import com.example.crm.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerShowDto extends BaseDto {
    private int id;
    private String fullName;
    private String number;

    public CustomerShowDto(Customer domain) {
        this.id = domain.getId();
        this.fullName = domain.getFirstName() + " " + domain.getLastName();
        this.number = domain.getPhoneNumber();
    }
}
