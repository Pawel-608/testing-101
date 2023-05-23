package com.rainer.pawel.intro._5_;

import java.io.FileWriter;
import java.io.IOException;

public class StringFileWriter {

    public boolean write(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
