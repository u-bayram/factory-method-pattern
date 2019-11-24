package factorymethod;

import factorymethod.samples.Hp;
import factorymethod.samples.Printer;
import factorymethod.samples.PrinterFactory;
import factorymethod.samples.Xenox;

import java.util.ArrayList;
import java.util.List;

/**
 * @author umut.bayram
 */
public class FactoryMethod {

    public static void main(String args[]) {
        List<Printer> printers = new ArrayList<Printer>();

        printers.add(PrinterFactory.createPrinter(Xenox.class));
        printers.add(PrinterFactory.createPrinter(Hp.class));
        printers.add(PrinterFactory.createPrinter(Xenox.class));
        printers.add(PrinterFactory.createPrinter(Hp.class));
        printers.add(PrinterFactory.createPrinter(Xenox.class));

        showPrinters(printers);
    }

    private static void showPrinters(List<Printer> printers) {
        printers.stream().forEach(printer -> {
            System.out.println(printer.getPrinterName());
        });
    }
}
