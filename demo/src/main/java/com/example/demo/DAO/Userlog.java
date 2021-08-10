package com.example.demo.DAO;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "userlog")
public class Userlog extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String UserIP;

    @Column
    private String Mail;

    @Column
    private String Result;

    @Builder
    public Userlog(String UserIP, String Mail, String Result){

        this.UserIP = UserIP;
        this.Mail = Mail;
        this.Result = Result;

    }

}
