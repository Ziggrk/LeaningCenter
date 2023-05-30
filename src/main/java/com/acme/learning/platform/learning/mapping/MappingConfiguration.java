package com.acme.learning.platform.learning.mapping;

import com.acme.learning.platform.learning.domain.model.Skill;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public StudentMapper studentMapper() {
        return new StudentMapper();
    }

    @Bean
    public SkillMapper skillMapper(){
        return  new SkillMapper();
    }
}
