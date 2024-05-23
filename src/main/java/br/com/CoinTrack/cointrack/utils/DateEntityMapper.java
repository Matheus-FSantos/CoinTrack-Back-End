package br.com.CoinTrack.cointrack.utils;

import br.com.CoinTrack.cointrack.exceptions.specializations.InvalidFields;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class DateEntityMapper {

    public static void validate(List<String> messages, String date) {
        try {
            DateEntityMapper.toLocalDate(date);
        } catch (DateTimeParseException e) {
            messages.add("The date field is invalid, its format must be: dd/MM/yyyy.");
        }
    }

    public static LocalDate toLocalDate(String date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, pattern);
    }

}
