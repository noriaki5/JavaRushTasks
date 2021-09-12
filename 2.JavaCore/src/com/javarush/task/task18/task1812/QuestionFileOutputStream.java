package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream originalStream;

    public QuestionFileOutputStream(AmigoOutputStream originalStream) {
        this.originalStream = originalStream;
    }

    @Override
    public void flush() throws IOException {
        originalStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        originalStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        originalStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        originalStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Вы действительно хотите закрыть поток? Д/Н");
            String answer = bufferedReader.readLine();
            if (answer.equals("Д")) {
                originalStream.close();
            }
        }

    }
}

