package other;

public class shuxing {
    // ID: 1:力量 2:智力 3：体力 4：速度 5：技巧
    public int ID;
    public String name;
    public int Data_base;
    public int Data_max;
    public int Data_min;

    public shuxing(int ID, int data_base, int data_max, int data_min) {
        this.ID = ID;
        Data_base = data_base;
        Data_max = data_max;
        Data_min = data_min;
    }
    public shuxing(){

    }
    public void ID_to_name(){
        switch (ID){
            case 1: name="力量";break;
            case 2: name="智力";break;
            case 3: name="体力";break;
            case 4: name="速度";break;
            case 5: name="技巧";break;
            default: System.out.println("SHuxing name Error!");break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getData_base() {
        return Data_base;
    }

    public void setData_base(int data_base) {
        Data_base = data_base;
    }

    public int getData_max() {
        return Data_max;
    }

    public void setData_max(int data_max) {
        Data_max = data_max;
    }

    public int getData_min() {
        return Data_min;
    }

    public void setData_min(int data_min) {
        Data_min = data_min;
    }
}
