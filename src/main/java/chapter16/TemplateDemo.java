package chapter16;

import java.sql.SQLException;

/**
 * 使用JDBC操作数据库
 */
public class TemplateDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String pwd = "root";

        SimpleConnectionDataSource dataSource = new SimpleConnectionDataSource(url, user, pwd);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        try {
            jdbcTemplate.update("INSERT INTO t_message(name, email, msg, number) VALUES (?,?,?,?)",
                    "测试员", "tester@qq.com", "这是一条测试", 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
