/**
 * @Author binblink
 * @Create Time　2018/4/8 21:50
 * @Description:
 */
public class Test {

    public static String add(){

        int count = 0;

        text(count);

        return "";
    }

    public static String  text(int count){


        if(count<=4){

            System.out.println("count--"+count);
            count++;
            text(count);
        }


        return "";
    }

    public static void main(String[] args) {


        add();
    }
}
