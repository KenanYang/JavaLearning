package printerDemo;
import printerDemo.impl.ColorInkBoxImpl;
import printerDemo.impl.A4PaperImpl;
public class PrinterTest {
    public static void main(String[] args) {
        Printer printer = new Printer();

        //为打印机安装纸张和墨盒
        printer.setInkBox(new ColorInkBoxImpl());
        printer.setPaper(new A4PaperImpl());


        printer.print("测试内容");
    }
}
