package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
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
        flush();
        write("JavaRush © All rights reserved.".getBytes());
        originalStream.close();
    }

    @Override
    public FileChannel getChannel() {
        return originalStream.getChannel();
    }


    @Override
    public void flush() throws IOException {
        originalStream.flush();
    }

    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream originalStream;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.originalStream = fileOutputStream;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
