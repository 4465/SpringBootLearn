package com.xianfeng.bean;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@ToString
@NoArgsConstructor  //无参构造器
@AllArgsConstructor //全参构造器
@EqualsAndHashCode
public class Ring {
    private String band;
    private Integer price;
}
