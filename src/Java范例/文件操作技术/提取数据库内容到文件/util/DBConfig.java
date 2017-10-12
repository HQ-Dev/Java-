package Java范例.文件操作技术.提取数据库内容到文件.util;

public interface DBConfig {
    // 设置JDBC基本信息，使用的是MySQL数据库。
    String URL = "jdbc:mysql://localhost:3306/db_database17";
    String DRIVER = "com.mysql.jdbc.Driver";
    String USERNAME = "root";
    String PASSWORD = "123456";
}
