package pers.wzs.demo.lombok;

/**
 * Created by wangzhongshan on 2017/5/3.
 */
public class LombokTest {
    public static void main(String[] args) {
        User wzs = User.builder().userId(1L).userName("wzs").sex(true).age(30).build();
    }
}
