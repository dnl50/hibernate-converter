package org.hibernate.converter.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigInteger;

/**
 * JPA {@link AttributeConverter} which converts between uppercase Hex Strings and {@link BigInteger}s.
 */
@Converter
public class BigIntegerHexAttributeConverter implements AttributeConverter<BigInteger, String> {

    private static final int HEX_RADIX = 16;

    @Override
    public String convertToDatabaseColumn(BigInteger attribute) {
        return attribute != null ? attribute.toString(HEX_RADIX).toUpperCase() : null;
    }

    @Override
    public BigInteger convertToEntityAttribute(String hex) {
        return hex != null ? new BigInteger(hex, HEX_RADIX) : null;
    }

}
