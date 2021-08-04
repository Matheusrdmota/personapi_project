package com.digitalinnovationone.personapi.utils;

import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.dto.request.PhoneDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.entity.Phone;
import com.digitalinnovationone.personapi.enums.PhoneType;

import java.time.LocalDate;
import java.util.Collections;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

}
