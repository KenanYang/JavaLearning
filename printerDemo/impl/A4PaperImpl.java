package printerDemo.impl;

import printerDemo.iface.IPaper;

public class A4PaperImpl implements IPaper {
    @Override
    public String getSize(){
        return "A4";
    }
}
