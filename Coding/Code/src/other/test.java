package other;

public class test {
    public zhuangbei zhuanga = new zhuangbei();
    public int int_zhuanga(int color, int lei, int zhulei, int zhu, int fu){
        zhuanga.setName("铁锋利刃");
        zhuanga.setLei(lei);
        zhuanga.setBase_zhu(zhu);
        zhuanga.setBase_fu(fu);
        zhuanga.ping.setColor(color);
        zhuanga.zhu.setID(zhulei); //设置主属性
        zhuanga.raninit();
        zhuanga.print();
        return zhuanga.print_Pingji();
    }

    public test() {
    }
};

