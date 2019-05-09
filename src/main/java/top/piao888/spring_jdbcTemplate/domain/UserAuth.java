package top.piao888.spring_jdbcTemplate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAuth {
    private Long did;
    private String dname;

    @Override
    public String toString() {
        return "UserAuth{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
