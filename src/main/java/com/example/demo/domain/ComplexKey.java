package com.example.demo.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ComplexKey implements Serializable {
    private String category;
    private String item;
}
