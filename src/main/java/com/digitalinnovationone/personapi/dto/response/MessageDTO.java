package com.digitalinnovationone.personapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDTO {
    private String message;
}
