package rpg;

public abstract  class Hero{
    private long id;
    private String name;
    private int level;
    private int maxHp;
    private int hp;
    private int attack;
    private int x;
    private int y;

    public Hero(){
        setMaxHp(100);
        setHp(100);
    }


    public Hero(long id, String name){
        this();
        setId(id);
        setName(name);
    }
    /**
    * 使用模版模式实现的对战方法
    * 规定了默认情况下对战的流程
    */

    public void PK(Hero hero){
        //1. 计算距离判断是否能够攻击对方
        if(canFightByDistance(hero) && hp > 0 && hero.getHp() > 0){
            //2.如果可以攻击，就调用攻击方法
            fight(hero);
        }else{
            System.out.println("由于攻击距离或其他原因，攻击失败！");
        }
        //3. 在控制台打印对战的结果（控制台程序专用）
        System.out.println("两位英雄当前状态");
        System.out.println("昵称\tHP\tX坐标\tY坐标");
        System.out.println(name + "\t" + hp + "\t" +x +"\t" +y);
        System.out.printf("%s\t%d\t%d\t%d\n", hero.getName(), hero.getHp(), hero.getX(), hero.getY());
    }

    /**
    *判断当前英雄是否能够攻击传入的英雄对象
    */

    public abstract boolean canFightByDistance(Hero hero);
    //攻击传入的英雄，默认根据随机生成的攻击力减扣hp值
    public abstract void fight(Hero hero);

    protected double getDistance(int x1, int y1, int x2, int y2){
          return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }


    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setLevel(int level){
        if(level < 0||level>100){
            level = 1;
        }
        this.level = level;
    }
    public int getLevel(){
        return this.level;
    }

    public void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    }
    public int getMaxHp(){
        return this.maxHp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }
    public int getHp(){
        return this.hp;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }
    public int getAttack(){
        return this.attack;
    }

    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return this.x;
    }

    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return this.y;
    }

}
