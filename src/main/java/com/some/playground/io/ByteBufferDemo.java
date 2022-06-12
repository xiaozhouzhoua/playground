package com.some.playground.io;

import java.nio.ByteBuffer;

public class ByteBufferDemo {
    public static void main(String[] args) {
        // mark = -1, position = 0, limit = 10
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // mark = -1, position = 2, limit = 10
        buffer.position(2);
        // mark = 2,  position = 2, limit = 10
        buffer.mark();
        // mark = 2,  position = 5, limit = 10
        buffer.position(5);
        // mark = 2,  position = 5, limit = 8
        buffer.limit(8);

        // mark = -1, position = 0, limit = 10
        buffer.clear();
        // mark = -1, position = 0, limit = 5
        buffer.flip();
        // mark = -1, position = 0, limit = 8
        buffer.rewind();
        // mark = -1, position = 3, limit = 10
        buffer.compact();
    }
}
