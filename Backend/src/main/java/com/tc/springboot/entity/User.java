package com.tc.springboot.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name="tc_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tc_num;
    private String tc_id;
    private String tc_password;
    private String tc_email;

    @Builder
    public User(String tc_id, String tc_password, String tc_email) {
        this.tc_id = tc_id;
        this.tc_password = tc_password;
        this.tc_email = tc_email;
    }

    public void update(String tc_id, String tc_password, String tc_email) {
        this.tc_id = tc_id;
        this.tc_password = tc_password;
        this.tc_email = tc_email;
    }
}
