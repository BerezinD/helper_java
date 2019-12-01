package runnable;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Main {

    public static void main(String[] args) {
       log.println("The very first bytes of *.class files is 0xCAFEBABE");
       // here link to ORACLE Documentation https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javap.html
       log.println("javap - The Java Class File Disassembler");

    }
}
