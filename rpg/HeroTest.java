package rpg;

public class HeroTest {
    public static void main(String[] args) {
        //两个战士之间的对战
        Hero hero1 = new Warrior(1, "盖伦", 0, 0);
        Hero hero2 = new Warrior(2, "貂蝉", 10, 10);

        hero1.PK(hero2);
        hero2.PK(hero1);
    }
}
