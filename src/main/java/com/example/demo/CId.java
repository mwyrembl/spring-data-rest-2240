package com.example.demo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CId implements Serializable {

    @Serial
    private static final long serialVersionUID = 9188026199478198725L;

    @ManyToOne
    private A a;

    @ManyToOne
    private B b;
}
