package com.demozi.spring.boot.data.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 *  CREATE TABLE `tb_user` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `user_name` varchar(45) NOT NULL,
 *   `password` varchar(45) NOT NULL,
 *   `email` varchar(45) DEFAULT NULL,
 *   `phone_number` int(11) DEFAULT NULL,
 *   `description` varchar(255) DEFAULT NULL,
 *   `create_time` datetime DEFAULT NULL,
 *   `update_time` datetime DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 *
 *
 * @author wujian  2023/8/9 14:18
 */
@Getter
@Setter
@ToString
@Entity
@TableName("tb_user")
public class User implements BaseEntity {

    /**
     * user id. 使用自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * username.
     */
    private String userName;

    /**
     * user pwd.
     */
    private String password;

    /**
     * email.
     */
    private String email;

    /**
     * phoneNumber.
     */
    private long phoneNumber;

    /**
     * description.
     */
    private String description;

    /**
     * create date time.
     */
    private LocalDateTime createTime;

    /**
     * update date time.
     */
    private LocalDateTime updateTime;
}
