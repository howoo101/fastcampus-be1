package me.day23.io.writer;

import me.day23.io.util.FileUtil;

import java.io.*;

public class WriterWriteExample1 {
    static final String path = FileUtil.getOutPath( WriterWriteExample1.class );
    static final String filename = "output.txt";
    public static void main(String[] args) {
        final char[] data = "가 나 다 라 마 바 사 아".toCharArray(); // 자바에서 한글 지원하기 때문에 (유니코드) 깨지지 않음
//            char[] data = "a b c d e f g h i j k".toCharArray(); // "a", "b", "c" ... "k"를 하나씩 출력

        try ( Writer writer = new FileWriter(path + filename) ) {
            for (int i = 0; i < data.length; i++) {
                writer.write(data[i]);
            }
            writer.flush();
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
