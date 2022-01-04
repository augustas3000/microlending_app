package com.microlending.microlendingapp.entities.converters;

import com.microlending.microlendingapp.entities.borrower.GermanZipcode;
import com.microlending.microlendingapp.entities.borrower.SwissZipcode;
import com.microlending.microlendingapp.entities.borrower.Zipcode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ZipcodeConverter implements AttributeConverter<Zipcode, String> {
    @Override
    public String convertToDatabaseColumn(Zipcode attribute) {
        return attribute.getValue();
    }

    @Override
    public Zipcode convertToEntityAttribute(String s) {
        if (s.length() == 5)
            return new GermanZipcode(s);
        else if (s.length() == 4)
            return new SwissZipcode(s);
        throw new IllegalArgumentException(
                "Unsupported zipcode in database: " + s
        );
    }
}
