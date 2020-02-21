package how2j.reflection;

/**
 * @program: mongomanager
 * @description: 英雄类
 * @author: WangPengfei
 * @create: 2019-03-25 10:15
 **/
public class Hero {

    public String name;

    public Double health;

    public Long attack;

    public int id;

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public Long getAttack() {
        return attack;
    }

    public void setAttack(Long attack) {
        this.attack = attack;
    }

    public void attackHero(Hero h2) {
        System.out.println(this.name + "正在攻击" + h2.getName());
    }
}
