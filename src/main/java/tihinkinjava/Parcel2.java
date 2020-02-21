package tihinkinjava;

public class Parcel2 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    //外部类有一个返回内部类对象的方法
    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Shandong");
        Parcel2 q = new Parcel2();
        //创建两个指向内部类的引用
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Jinan");
    }
}
