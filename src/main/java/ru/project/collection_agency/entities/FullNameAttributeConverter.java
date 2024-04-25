package ru.project.collection_agency.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Converter
public class FullNameAttributeConverter implements AttributeConverter<FullName, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(FullNameAttributeConverter.class);

    public String convertToDatabaseColumn(FullName fullName)
    {
        try
        {
            return objectMapper.writeValueAsString(fullName);
        }
        catch (JsonProcessingException jpe)
        {
            log.warn("Cannot convert Fullname into JSON");
            return null;
        }
    }

    public FullName convertToEntityAttribute(String value)
    {
        try
        {
            return objectMapper.readValue(value, FullName.class);
        }
        catch (JsonProcessingException e)
        {
            log.warn("Cannot convert JSON into Fullname");
            return null;
        }
    }
}
