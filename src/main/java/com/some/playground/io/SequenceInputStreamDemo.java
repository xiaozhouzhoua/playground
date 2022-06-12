package com.some.playground.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

/**
 * It just combines all underlying input streams into one single stream.
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        try(InputStream first = new ByteArrayInputStream("Jun".getBytes());
            InputStream second = new ByteArrayInputStream("one".getBytes());
            SequenceInputStream sequenceInputStream = new SequenceInputStream(first, second)
        ) {
            StringBuilder sb = new StringBuilder();
            int byteValue;
            while ((byteValue = sequenceInputStream.read()) != -1) {
                sb.append((char) byteValue);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
