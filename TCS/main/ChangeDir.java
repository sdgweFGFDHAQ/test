package TCS.main;

/**
 * 改变蛇头的方向
 */
public class ChangeDir {
    //蛇头的方向
    private String head_dir="ActionRight";
//    //蛇尾的方向
//    private String tail_dir="ActionRight";

    public String getHead_dir() {
        return head_dir;
    }

    public void setHead_dir(String head_dir) {
        this.head_dir = head_dir;
    }

//    public String getTail_dir() {
//        return tail_dir;
//    }
//
//    public void setTail_dir(String tail_dir) {
//        this.tail_dir = tail_dir;
//    }

    public void ActionUp(){
        System.out.println("方向为向上");
    }
    public void ActionDown(){
        System.out.println("方向为向下");
    }
    public void ActionLeft(){
        System.out.println("方向为向左");
    }
    public void ActionRight(){
        System.out.println("方向为向右");
    }
}
