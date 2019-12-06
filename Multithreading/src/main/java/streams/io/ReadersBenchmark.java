package streams.io;

import static streams.io.JavaIOTest.useFileChannel;
import static streams.io.JavaIOTest.useNormalIO;

public class ReadersBenchmark {

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
        useNormalIO();
        useFileChannel();
    }
}
