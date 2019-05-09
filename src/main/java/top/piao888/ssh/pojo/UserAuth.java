package top.piao888.ssh.pojo;


import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name="dept2")
//其中用的注解的方式进行的映射，@Id是必须有的，@Column非必须，如果字段名和列名相同的话就不需要加
public class UserAuth {

    private Integer did;
    private String dname;

    @Id
    //列明   是否为空     长度    是否唯一
    @Column(name="id",nullable = false,length = 32,unique = true)
    // 给生成策略取名   生成策略所用的策略方式
    @GenericGenerator(name="generator",strategy = "uuid.hex")
    //使用 生成策略名为generator的  策略方式 生成这个列
    @GeneratedValue(generator = "generator")
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
    @Column(name="name",nullable = false,length = 32)
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
