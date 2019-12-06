package streams.io;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class JavaIOTest {
    private static final String PATH_NAME_ONE = "Multithreading\\src\\main\\resources\\test.iso";
    private static final String PATHNAME_SECOND = "Multithreading\\src\\main\\resources\\test2";

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public static void useNormalIO() throws Exception {
        File file = new File(PATH_NAME_ONE);
        File oFile = new File(PATHNAME_SECOND);
        long time1 = System.currentTimeMillis();

        try (FileOutputStream fos = new FileOutputStream(oFile);
             InputStream is = new FileInputStream(file)) {
            byte[] buf = new byte[64 * 1024];
            int len;
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
        }
        long time2 = System.currentTimeMillis();
        log.println("Time taken: "+(time2-time1)+" ms");
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public static void useFileChannel() throws Exception {
        File file = new File(PATH_NAME_ONE);
        File oFile = new File(PATHNAME_SECOND);
        long time1 = System.currentTimeMillis();

        try (FileInputStream is = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(oFile)) {
            FileChannel f;
            FileChannel f2;

            f = is.getChannel();
            f2 = fos.getChannel();
            ByteBuffer buf = ByteBuffer.allocateDirect(64 * 1024);
            long len = 0;

            while((len = f.read(buf)) != -1) {
                buf.flip();
                f2.write(buf);
                buf.clear();
            }
            f2.close();
            f.close();
        }

        long time2 = System.currentTimeMillis();
        log.println("Time taken: "+(time2-time1)+" ms");
    }
}
