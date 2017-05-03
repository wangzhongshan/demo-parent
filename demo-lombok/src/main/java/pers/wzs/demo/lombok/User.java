package pers.wzs.demo.lombok;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by wangzhongshan on 2017/5/3.
 */
@Data
@Builder
public class User {
    private Long userId;
    private String userName;
    private Integer age;
    private Boolean sex;
    private LocalDateTime createTime;
}
