package com.first.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String email;
    // Lombok 已经自动生成了 getter 和 setter 方法
    // Lombok @AllArgsConstructor 生成了包含所有字段的构造函数
    // Lombok @NoArgsConstructor 生成了无参构造函数
    // Lombok @Data 生成了 toString, equals, 和 hashCode 方法
}