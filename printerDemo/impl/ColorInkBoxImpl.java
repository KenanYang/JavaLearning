package printerDemo.impl;
import printerDemo.iface.IInkBox;

public class ColorInkBoxImpl implements IInkBox {
    @Override
    public String getColor(){
        return "红色";
    }
}
