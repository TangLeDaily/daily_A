package ShuaTi;

public class Chouka {
    public int Already;
    public int miniAlready;
    public Boolean LastFiveIsUp;
    public String FiveUpName = "雷电将军";
    public String FourUpName1 = "班尼特";
    public String FourUpName2 = "九条裟罗";
    public String FourUpName3 = "辛焱";

    public int FiveSum = 6;
    public String FiveName[] = {FiveUpName, "刻晴", "莫娜", "七七", "迪卢克", "琴"};
    public String FourName[] = {FourUpName1, FourUpName2, FourUpName3,
            "云堇",
            "九条裟罗",
            "五郎",
            "早柚",
            "烟绯",
            "罗莎莉亚",
            "辛焱",
            "砂糖",
            "重云",
            "诺艾尔",
            "班尼特" ,
            "凝光" ,
            "行秋" ,
            "北斗" ,
            "香菱" ,
            "雷泽" ,
            "芭芭拉" ,
            "弓藏" ,
            "祭礼弓" ,
            "绝弦" ,
            "西风猎弓" ,
            "昭心" ,
            "祭礼残章" ,
            "流浪乐章" ,
            "西风秘典" ,
            "西风长枪" ,
            "匣里灭辰" ,
            "雨裁" ,
            "祭礼大剑" ,
            "钟剑" ,
            "西风大剑" ,
            "匣里龙吟" ,
            "祭礼剑" ,
            "笛剑" ,
            "西风剑"};

    public int getFiveGL(){
        if(Already<73){
            return 6;
        }
        else{
            switch (Already){
                case 73: return 66;
                case 74: return 126;
                case 75: return 186;
                case 76: return 246;
                case 77: return 306;
                case 78: return 366;
                case 79: return 426;
                case 80: return 486;
                case 81: return 546;
                case 82: return 606;
                case 83: return 666;
                case 84: return 726;
                case 85: return 786;
                case 86: return 846;
                case 87: return 906;
                case 88: return 966;
                case 89: return 1000;
                default: return 6;
            }
        }
    }
    public int getFourGL(){
        if(miniAlready<8){
            return 51;
        }
        else if(miniAlready == 8){
            return 561;
        }
        else{
            return 1000;
        }
    }
    public int getWhichFive(){
        if(LastFiveIsUp){
            if(getRandom(2)==0){
                LastFiveIsUp = true;
                return 0;
            }
            else{
                LastFiveIsUp = false;
                return 1 + getRandom(5);
            }
        }
        else LastFiveIsUp = true;return 0;
    }

    public int getWhichFour(){
        if(getRandom(2)==0){
            return FiveSum + getRandom(3);
        }
        else{
            return FiveSum + 3 + getRandom(35);
        }
    }
    /*
    获取[0,1000)的随机数
     */
    public int getRandom(int num){
        final double d = Math.random();
        return (int)(d*num);
    }

    public int Chou(){
        int WhatLevel = getRandom(1000);
        int FiveGL = getFiveGL();
        int FourGL = getFourGL();
        int ChouID;
        if (WhatLevel<=FiveGL){
            //抽到了5星
            ChouID = getWhichFive();
            Already = 0;
        }
        else if(WhatLevel<=FourGL){
            //抽到了4星
            ChouID = getWhichFour();
            Already++;
            miniAlready = 0;
        }
        else{
            //抽到了3星
            ChouID = 999;
            Already++;
            miniAlready++;
        }
        return ChouID;
    }

    public void SettingAlready(int Al, int miniAl, Boolean last){
        Already = Al;
        miniAlready = miniAl;
        LastFiveIsUp = last;
    }
    public void TenChou(){
        int ID[] = new int[10];
        String Xingji[] = new String[10];
        String Name[] = new String[10];
        System.out.println("此前已经有 "+Already+" 抽未出5星！上次5星角色为：");
        if(LastFiveIsUp) System.out.println("Up角色！本次Up角色概率为50%！");
        else System.out.println("非Up角色！本次Up角色概率为100%！");
        System.out.println("此前已经有 "+miniAlready+" 抽未出4星！");
        System.out.println("本次十连结果如下：\n");
        for(int i=0;i<10;i++){
            ID[i] = Chou();
            if(ID[i] == 999){
                Xingji[i] = "三星";
                Name[i] = "三星物品";
            }
            else if(ID[i] <= 5){
                Xingji[i] = "五星";
                Name[i] = FiveName[ID[i]];
            }
            else{
                Xingji[i] = "四星";
                Name[i] = FourName[ID[i] - 6];
            }
            System.out.println(Xingji[i] + " -- " + Name[i]);
        }
    }
}

