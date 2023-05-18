package com.acme.leaningcenter.platform.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration{
    @Bean // Tipo de singleton(?
    public EnhancedModelMapper modelMapper(){
        return new EnhancedModelMapper();
    }
}
