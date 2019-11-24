package factorymethod.samples;

/**
 * @author umut.bayram
 */
public class PrinterFactory {

    public static Printer createPrinter(Class<? extends Printer> printer) {
        try {
            return printer.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Printer is not");
        }
    }
}
