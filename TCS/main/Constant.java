package TCS.main;

public class Constant {
    //游戏地图的参数
    static final int FILLRECT_WEIGTH=1000;
    static final int FILLRECT_HEIGHT=600;
    static final int FILLRECT_X=20;
    static final int FILLRECT_Y=60;

    //加载图片的参数(蛇的初始化)
    static final int PICTURE_SIZE=50;
    static final int START_X=FILLRECT_X+200;
    static final int START_Y=FILLRECT_Y+200;
    static final int LENGTH=3;

    //遍历整个游戏地图需要的次数
    static final int X_MOVE=FILLRECT_WEIGTH/Constant.PICTURE_SIZE;
    static final int Y_MOVE=FILLRECT_HEIGHT/Constant.PICTURE_SIZE;

    //窗口显示信息
    static final String Game_Name="贪吃蛇";
    static final String Scores="分数:";
    static final int WINDOWX=2*FILLRECT_X+FILLRECT_WEIGTH;
    static final int WINDOWY=2*FILLRECT_Y+FILLRECT_HEIGHT;
}
