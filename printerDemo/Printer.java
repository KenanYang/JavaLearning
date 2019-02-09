package printerDemo;
import printerDemo.iface.IPaper;
import printerDemo.iface.IInkBox;

public class Printer {
    private IInkBox inkBox = null;  //打印机中的墨盒
    private IPaper paper = null;  //打印机中的纸张

    public void print(String content){
        if(null == inkBox || null == paper){
            System.out.println("墨盒和纸张出现错误，请安装正确后重试！");
            return;
        }

        //打印过程
        String color = inkBox.getColor();
        String size = paper.getSize();
        System.out.println("以下文字是"+ color + "颜色的！");
        System.out.println("使用纸张：" + size);
        System.out.println("打印内容：" + content);
    }
    public IInkBox getInkBox(){
        return inkBox;
    }
    public void setInkBox(IInkBox inkBox){
        this.inkBox = inkBox;
    }
    public IPaper getPaper(){
        return paper;
    }
    public void setPaper(IPaper paper){
        this.paper = paper;
    }
}
