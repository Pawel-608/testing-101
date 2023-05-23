package com.rainer.pawel.intro._5_;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class StringSplittingRepository {

    private final StringFileWriter stringFileWriter;

    public StringSplittingRepository(StringFileWriter stringFileWriter) {
        this.stringFileWriter = stringFileWriter;
    }

    public String save(String filePath, String s) {
        String splittedString = Arrays.stream(s.split(""))
                .map(character -> character + "\n")
                .collect(joining()); // dodaje do siebie wszystkie stringi cos jak arr[0] + arr[1] + ... + arr[n]

        if (!stringFileWriter.write(filePath, splittedString)) {
            throw new SplittingRepositoryException("Error occurred while writing to file");
        }

        return splittedString;
    }
}
