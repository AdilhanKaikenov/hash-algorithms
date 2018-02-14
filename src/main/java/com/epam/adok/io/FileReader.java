package com.epam.adok.io;

import com.epam.adok.exception.FileReadingException;

import java.io.*;

public class FileReader implements Reader {

    public byte[] read(String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileReadingException("File - " + file + " was not found.");
        }

        byte[] bytes = new byte[(int)file.length()];

        try (DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));) {
            inputStream.readFully(bytes);
        } catch (IOException e) {
            throw new FileReadingException("Error in FileReader in read() method:",  e);
        }
        return bytes;
    }
}
