public class testPlusSigninString{

    private int ID = 1;
    private String name;

    public void setName(String name){
        this.name = name+ID;
    }

    public String getName(){
        return this.name;
    }



    public static void main(String[] args){
        testPlusSigninString t1 = new testPlusSigninString();
        t1.setName("Wang Er Gou");
        System.out.println(t1.getName();
    }
}
