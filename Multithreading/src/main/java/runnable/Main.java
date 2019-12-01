package runnable;

import org.openjdk.jol.info.ClassLayout;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Main {

    public static void main(String[] args) {
       log.println("The very first bytes of *.class files is 0xCAFEBABE");
       // here link to ORACLE Documentation https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javap.html
       log.println("javap - The Java Class File Disassembler");
       MemoryRelocated newObject = new MemoryRelocated();
       log.println(ClassLayout.parseInstance(newObject).toPrintable());
    }
}

/**
 * from concurrency course
 * this class is the example of memory usage.
 */
class MemoryRelocated {

    // header 32bit - 8 bytes, 64bit - 12 bytes
    private int firstInt;       // 4 bytes
    private short secondShort;    // 2 bytes
    // padding (выравнивание) to x8 bytes - in our case padding = 24-(4+2+12) = 6
    // total size of new object of this class is 24 bytes.
}