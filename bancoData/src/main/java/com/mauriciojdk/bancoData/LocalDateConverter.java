package com.mauriciojdk.bancoData;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter extends AbstractBeanField {

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime parse = LocalDateTime.parse(value, formatter);
        return parse;
    }

}
