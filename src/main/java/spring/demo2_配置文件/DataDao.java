package spring.demo2_配置文件;


import javax.sql.DataSource;

/**
 * Created by wushang on 15/10/21.
 */
public class DataDao {
    private String userName;
    private String password;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
