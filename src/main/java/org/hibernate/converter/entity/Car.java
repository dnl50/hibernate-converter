package org.hibernate.converter.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Convert(converter = BigIntegerHexAttributeConverter.class)
    @Column(name = "SERIAL", nullable = false, length = 100)
    private BigInteger serial;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigInteger getSerial() {
        return serial;
    }

    public void setSerial(BigInteger serial) {
        this.serial = serial;
    }

}
