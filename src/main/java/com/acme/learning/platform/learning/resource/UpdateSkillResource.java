package com.acme.learning.platform.learning.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateSkillResource {
    @NotNull
    @NotBlank
    @Size(max=60)
    String name;
}
