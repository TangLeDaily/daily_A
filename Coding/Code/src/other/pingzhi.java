package other;

public class pingzhi {
    // 1:白色 2：绿色 3：蓝色 4：紫色 5：橙色 6：红色
    public int color;
    public String color_name;
    public double pingfen;
    public int pingji;

    public pingzhi(){

    }

    public pingzhi(int color, String color_name, double pingfen, int pingji) {
        this.color = color;
        this.color_name = color_name;
        this.pingfen = pingfen;
        this.pingji = pingji;
    }

    public void cal_pingji(){
        if(pingfen<-0.65){
            pingji = 1;
        }
        else if(pingfen<-0.45){
            pingji = 2;
        }
        else if(pingfen<-0.25){
            pingji = 3;
        }
        else if(pingfen<0.25){
            pingji = 4;
        }
        else if(pingfen<0.45){
            pingji = 5;
        }
        else if(pingfen<0.65){
            pingji = 6;
        }
        else{
            pingji = 7;
        }

    }
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        color_to_name();
    }

    public void color_to_name(){
        switch (color){
            case 1: color_name="白色";break;
            case 2: color_name="绿色";break;
            case 3: color_name="蓝色";break;
            case 4: color_name="紫色";break;
            case 5: color_name="橙色";break;
            case 6: color_name="红色";break;
            default:color_name="???";break;
        }
    }
    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public double getPingfen() {
        return pingfen;
    }

    public void setPingfen(double pingfen) {
        this.pingfen = pingfen;
    }

    public int getPingji() {
        return pingji;
    }

    public void setPingji(int pingji) {
        this.pingji = pingji;
    }
}
