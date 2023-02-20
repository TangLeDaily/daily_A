package other;

import java.util.ArrayList;
import java.util.List;

public class zhuangbei {
    // ID: 10:主手武器， 11：副手武器， 12：双手武器
    // 其他第一位：2为防具，3为饰品
    // 其他第三位 0为布甲，1为皮甲， 2为锁甲， 3为板甲
    // 20: 头盔 21：胸甲 22：腰带 23：腿甲 24：鞋子 25：披风 26：护肩 27：手腕 28：手套
    // 30: 项链 31：戒指1 32:戒指2 33:
    public int lei;
    public String lei_name;
    public String pingji_name;
    public int base_zhu;
    public int base_fu;
    public String Name;
    public shuxing zhu = new shuxing();
    public List<shuxing> fu = new ArrayList<shuxing>();
    public double zhu_fu;
    public double fu_fu[] = new double[5];
    public int fu_num;
    public pingzhi ping = new pingzhi();

    public double rand(){
        // get [0,1) random
        return Math.random();
    }
    public int rand_range(int num){
        // get [1, num] int_random
        return (int)(rand()*num)+1;
    }
    public int rand_range_zero(int num){
        // get [1, num] int_random
        return (int)(rand()*(num+1));
    }

    public zhuangbei(){

    }
    public zhuangbei(int base_zhu, int base_fu, shuxing zhu, List<shuxing> fu, pingzhi ping) {
        this.base_zhu = base_zhu;
        this.base_fu = base_fu;
        this.zhu = zhu;
        this.fu = fu;
        this.ping = ping;
    }

    public void raninit(){
        // 完成属性分配
        switch (ping.getColor()){
            case 0:{
                System.out.println("Color Error! Color = 0");break;
            }
            case 1:{
                zhu_fu = (rand()*20+1.5-10)/100 + 1;
                zhu.setData_base((int)(zhu_fu*base_zhu));
                fu_num = 1;
                for (int i = 0; i < fu_num; i++){
                    shuxing shu_temp = new shuxing();
                    shu_temp.setID(rand_range(5));
                    fu_fu[i] = (rand()*35+1.5-20)/100 + 1;
                    shu_temp.setData_base((int)(fu_fu[i]*base_fu));
                    fu.add(shu_temp);
                }
                break;
            }
            case 2:{
                zhu_fu = (rand()*22+1.5-11)/100 + 1;
                zhu.setData_base((int)(zhu_fu*base_zhu));
                fu_num = 1;
                for (int i = 0; i < fu_num; i++){
                    shuxing shu_temp = new shuxing();
                    shu_temp.setID(rand_range(5));
                    fu_fu[i] = (rand()*40+1.5-20)/100 + 1;
                    shu_temp.setData_base((int)(fu_fu[i]*base_fu));
                    fu.add(shu_temp);
                }
                break;
            }
            case 3:{
                zhu_fu = (rand()*24+1.5-12)/100 + 1;
                zhu.setData_base((int)(zhu_fu*base_zhu));
                fu_num = 2;
                for (int i = 0; i < fu_num; i++){
                    shuxing shu_temp = new shuxing();
                    shu_temp.setID(rand_range(5));
                    fu_fu[i] = (rand()*45+1.5-20)/100 + 1;
                    shu_temp.setData_base((int)(fu_fu[i]*base_fu));
                    fu.add(shu_temp);
                }
                break;
            }
            case 4:{
                zhu_fu = (rand()*26+1.5-13)/100 + 1;
                zhu.setData_base((int)(zhu_fu*base_zhu));
                fu_num = 2;
                for (int i = 0; i < fu_num; i++){
                    shuxing shu_temp = new shuxing();
                    shu_temp.setID(rand_range(5));
                    fu_fu[i] = (rand()*50+1.5-20)/100 + 1;
                    shu_temp.setData_base((int)(fu_fu[i]*base_fu));
                    fu.add(shu_temp);
                }
                break;
            }
            case 5:{
                zhu_fu = (rand()*28+1.5-14)/100 + 1;
                zhu.setData_base((int)(zhu_fu*base_zhu));
                fu_num = 3;
                for (int i = 0; i < fu_num; i++){
                    shuxing shu_temp = new shuxing();
                    shu_temp.setID(rand_range(5));
                    fu_fu[i] = (rand()*55+1.5-20)/100 + 1;
                    shu_temp.setData_base((int)(fu_fu[i]*base_fu));
                    fu.add(shu_temp);
                }
                break;
            }
            case 6:{
                zhu_fu = (rand()*30+1.5-15)/100 + 1;
                zhu.setData_base((int)(zhu_fu*base_zhu));
                fu_num = 4;
                for (int i = 0; i < fu_num; i++){
                    shuxing shu_temp = new shuxing();
                    shu_temp.setID(rand_range(5));
                    fu_fu[i] = (rand()*60+1.5-20)/100 + 1;
                    shu_temp.setData_base((int)(fu_fu[i]*base_fu));
                    fu.add(shu_temp);
                }
                break;
            }
            default:{
                System.out.println("Color Error! Color = default");
                break;
            }
        }

        // 计算评级
        cal_pinfen();
    }
    public void cal_pinfen() {
        double zhu_fen=0;
        double fu_fen=0;
        double zong=0;
        switch (ping.getColor()) {
            case 0: {
                System.out.println("Fu Color Error! Color = 0");
                break;
            }
            case 1: {
                zhu_fen = (zhu_fu-1 - 0) / 0.20;
                double fu_fen_sum = 0;
                for (int i = 0; i < fu_num; i++) {
                    fu_fen_sum += (fu_fu[i]-1 - (-0.025)) / 0.35;
                }
                fu_fen = fu_fen_sum / fu_num * 0.5;
                zong = zhu_fen + fu_fen;
                ping.setPingfen(zong);
                break;
            }
            case 2: {
                zhu_fen = (zhu_fu-1 - 0.01) / 0.22;
                double fu_fen_sum = 0;
                for (int i = 0; i < fu_num; i++) {
                    fu_fen_sum += (fu_fu[i]-1 - (0)) / 0.40;
                }
                fu_fen = fu_fen_sum / fu_num * 0.5;
                zong = zhu_fen + fu_fen;
                ping.setPingfen(zong);
                break;
            }
            case 3: {
                zhu_fen = (zhu_fu-1 - 0.02) / 0.24;
                double fu_fen_sum = 0;
                for (int i = 0; i < fu_num; i++) {
                    fu_fen_sum += (fu_fu[i]-1 - (0.025)) / 0.45;
                }
                fu_fen = fu_fen_sum / fu_num * 0.5;
                zong = zhu_fen + fu_fen;
                ping.setPingfen(zong);
                break;
            }
            case 4: {
                zhu_fen = (zhu_fu-1 - 0.03) / 0.26;
                double fu_fen_sum = 0;
                for (int i = 0; i < fu_num; i++) {
                    fu_fen_sum += (fu_fu[i]-1 - (0.05)) / 0.50;
                }
                fu_fen = fu_fen_sum / fu_num * 0.5;
                zong = zhu_fen + fu_fen;
                ping.setPingfen(zong);
                break;
            }
            case 5: {
                zhu_fen = (zhu_fu-1 - 0.04) / 0.28;
                double fu_fen_sum = 0;
                for (int i = 0; i < fu_num; i++) {
                    fu_fen_sum += (fu_fu[i]-1 - (0.075)) / 0.55;
                }
                fu_fen = fu_fen_sum / fu_num * 0.5;
                zong = zhu_fen + fu_fen;
                ping.setPingfen(zong);
                break;
            }
            case 6: {
                zhu_fen = (zhu_fu -1- 0.05) / 0.30;
                double fu_fen_sum = 0;
                for (int i = 0; i < fu_num; i++) {
                    fu_fen_sum += (fu_fu[i]-1 - (0.10)) / 0.60;
                }
                fu_fen = fu_fen_sum / fu_num * 0.5;
                zong = zhu_fen + fu_fen;
                ping.setPingfen(zong);
                break;
            }
            default: {
                System.out.println("Ping Color Error! Color = default");
                break;
            }
        }
//        System.out.println(ping.getColor());
//        System.out.println("zhu_fu:"+zhu_fu);
//        System.out.println("Zhu_fen:"+zhu_fen);
//        for(int i =0;i<fu_num;i++){
//            System.out.println("fu_fu:"+fu_fu[i]);
//        }
//        System.out.println("fu_fen:"+fu_fen);
//        System.out.println("zong:"+zong);

        ping.cal_pingji();
    }

    public double getZhu_fu() {
        return zhu_fu;
    }
    public String getFormatLogString(String content, int colour) {
        // 37:白色  36:绿色 34:蓝色 35:紫色 33：黄色  31：红色  30：黑色
        int type = 0;
        boolean hasType = type != 1 && type != 3 && type != 4;
        if (hasType) {
            return String.format("\033[%dm%s\033[0m", colour, content);
        } else {
            return String.format("\033[%d;%dm%s\033[0m", colour, type, content);
        }
    }

    public void num_to_text(){
        switch (getLei()){
            // ID: 10:主手武器， 11：副手武器， 12：双手武器
            // 其他第一位：2为防具，3为饰品
            // 其他第三位 0为布甲，1为皮甲， 2为锁甲， 3为板甲
            // 20: 头盔 21：胸甲 22：腰带 23：腿甲 24：鞋子 25：披风 26：护肩 27：手腕 28：手套
            // 30: 项链 31：戒指1 32:戒指2 33:
            case 10: lei_name="主手武器";break;
            case 11: lei_name="副手武器";break;
            case 12: lei_name="双手武器";break;
            case 20: lei_name="头盔";break;
            case 21: lei_name="胸甲";break;
            case 22: lei_name="腰带";break;
            case 23: lei_name="腿甲";break;
            case 24: lei_name="鞋子";break;
            case 25: lei_name="披风";break;
            case 26: lei_name="护肩";break;
            case 27: lei_name="手腕";break;
            case 28: lei_name="手套";break;
            case 30: lei_name="项链";break;
            case 31: lei_name="戒指";break;
            case 32: lei_name="戒指";break;
            default: System.out.println("Leiname error!");break;
        }
        switch (ping.getPingji()){
            case 1: pingji_name="ZZZ：破烂不堪";break;
            case 2: pingji_name="D：磨损";break;
            case 3: pingji_name="C：普通";break;
            case 4: pingji_name="B：标准";break;
            case 5: pingji_name="A：优秀";break;
            case 6: pingji_name="S：极品";break;
            case 7: pingji_name="SSS：超凡绝品";break;
            default: System.out.println("pingji Error！");break;
        }
        zhu.ID_to_name();
        for(int i = 0;i<fu_num;i++){
            fu.get(i).ID_to_name();
        }
    }
    public String getColorName(String str){
        int this_color;
        switch (ping.color){
            case 1: this_color=37;break;
            case 2: this_color=36;break;
            case 3: this_color=34;break;
            case 4: this_color=35;break;
            case 5: this_color=33;break;
            case 6: this_color=31;break;
            default:this_color=37;System.out.println("ColorNameError!");break;
        }
        return getFormatLogString(str, this_color);
    }
    public String getColorPing(String str){
        int this_color;
        switch (ping.pingji){
            case 1: this_color=30;break;
            case 2: this_color=37;break;
            case 3: this_color=36;break;
            case 4: this_color=34;break;
            case 5: this_color=35;break;
            case 6: this_color=33;break;
            case 7: this_color=31;break;
            default:this_color=37;System.out.println("ColorPingError!");break;
        }
        return getFormatLogString(str, this_color);
    }

    public void print(){
        num_to_text();
        System.out.println("\n======================================");
        System.out.println("名称: "+getColorName(getName()));
        System.out.println("类别："+getLei_name());
        System.out.println("颜色："+getColorName(ping.getColor_name()));
        System.out.println("评分："+ping.getPingfen());
        System.out.println("品级："+getColorPing(getPingji_name()));
        System.out.println("主属性："+zhu.getName()+" +"+zhu.getData_base());
        System.out.println("副属性：");
        for (int i = 0; i<fu_num;i++){
            System.out.println(fu.get(i).getName()+" +"+fu.get(i).getData_base());
        }
        System.out.println("======================================\n");

    }

    public int print_Pingji(){
        return ping.getPingji();
    }

    public String getLei_name() {
        return lei_name;
    }

    public void setLei_name(String lei_name) {
        this.lei_name = lei_name;
    }

    public String getPingji_name() {
        return pingji_name;
    }

    public void setPingji_name(String pingji_name) {
        this.pingji_name = pingji_name;
    }

    public void setZhu_fu(double zhu_fu) {
        this.zhu_fu = zhu_fu;
    }

    public double[] getFu_fu() {
        return fu_fu;
    }

    public void setFu_fu(double[] fu_fu) {
        this.fu_fu = fu_fu;
    }

    public int getFu_num() {
        return fu_num;
    }

    public void setFu_num(int fu_num) {
        this.fu_num = fu_num;
    }

    public int getLei() {
        return lei;
    }

    public void setLei(int lei) {
        this.lei = lei;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getBase_zhu() {
        return base_zhu;
    }

    public void setBase_zhu(int base_zhu) {
        this.base_zhu = base_zhu;
    }

    public int getBase_fu() {
        return base_fu;
    }

    public void setBase_fu(int base_fu) {
        this.base_fu = base_fu;
    }

    public shuxing getZhu() {
        return zhu;
    }

    public void setZhu(shuxing zhu) {
        this.zhu = zhu;
    }

    public List<shuxing> getFu() {
        return fu;
    }

    public void setFu(List<shuxing> fu) {
        this.fu = fu;
    }

    public pingzhi getPing() {
        return ping;
    }

    public void setPing(pingzhi ping) {
        this.ping = ping;
    }
}
