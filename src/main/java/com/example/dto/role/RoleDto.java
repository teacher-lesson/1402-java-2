package com.example.dto.role;

import com.example.domain.role.Role;
import com.example.dto.IDomainDto;
import com.example.service.role.RoleMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements IDomainDto<Integer> {
    private Integer id;
    private String name;
    private boolean enable;
}
