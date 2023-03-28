package com.example.demo;

import lombok.val;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CBackendIdConverter implements BackendIdConverter {
    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        val ids = id.split("_");
        return CId.builder()
                .a(A.builder().id(Long.parseLong(ids[0])).build())
                .b(B.builder().id(Long.parseLong(ids[1])).build())
                .build();
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        val cId = (CId) id;
        return String.format("%s_%s", cId.getA().getId(), cId.getB().getId());
    }

    @Override
    public boolean supports(Class<?> delimiter) {
        return C.class.isAssignableFrom(delimiter);
    }
}
