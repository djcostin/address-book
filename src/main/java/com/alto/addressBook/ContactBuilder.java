package com.alto.addressBook;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ContactBuilder {

    private static DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yy");

    private String line;

    public ContactBuilder fromLine(String line) {
        this.line = line;
        return this;
    }

    public Contact build() {
        String[] fields = line.split(",");
        if (fields==null || fields.length!=3) {
            throw new IllegalArgumentException("line is not in correct format");
        }
        return new Contact(
                fields[0].split(" ")[0],
                fields[0].split(" ")[1],
                Contact.Gender.valueOf(fields[1].trim()),
                fmt.parseDateTime(fields[2].trim()).toLocalDate()
        );
    }
}
