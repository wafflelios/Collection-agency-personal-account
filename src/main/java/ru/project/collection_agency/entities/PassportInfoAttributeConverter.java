package ru.project.collection_agency.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Converter
public class PassportInfoAttributeConverter implements AttributeConverter<PassportInfo, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(PassportInfoAttributeConverter.class);

    public String convertToDatabaseColumn(PassportInfo passportInfo)
    {
        try
        {
            return objectMapper.writeValueAsString(passportInfo);
        }
        catch (JsonProcessingException jpe)
        {
            log.warn("Cannot convert PassportInfo into JSON");
            return null;
        }
    }

    public PassportInfo convertToEntityAttribute(String value)
    {
        try
        {
            return objectMapper.readValue(value, PassportInfo.class);
        }
        catch (JsonProcessingException e)
        {
            log.warn("Cannot convert JSON into PassportInfo");
            return null;
        }
    }
}
