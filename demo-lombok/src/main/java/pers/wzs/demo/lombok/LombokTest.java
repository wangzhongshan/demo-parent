package pers.wzs.demo.lombok;

/**
 * Created by wangzhongshan on 2017/5/3.
 */
public class LombokTest {
    public static void main(String[] args) {
        User wzs = User.builder().age(4).userId(1L).userName("wzs").sex(true).build();
    }
}
