package cn.knightzz.demo;

import cn.knightzz.pojo.Account;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author 王天赐
 * @title: JDBCDemo
 * @projectName lg-train-camp
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/11/3 13:28
 */
@SuppressWarnings("all")
public class JdbcConnectionDemo {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Account account = new Account();

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 通过驱动管理类获取数据库链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lg_camp?characterEncoding=utf-8&useSSL=false", "root", "123456");

            // 定义SQL语句, ? 表示占位符号
            String sql = "select * from account where name = ?";

            // 获取预处理的statement
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            // 设置参数，第⼀个参数为sql语句中参数的序号(从1开始)，第⼆个参数为设置的参数值
            preparedStatement.setString(1, "韩信");

            // 向数据库发出sql执⾏查询，查询出结果集
            resultSet = preparedStatement.executeQuery();

            // 遍历结果集
            while(resultSet.next()) {
                String cardNo = resultSet.getString("cardNo");
                String name = resultSet.getString("name");
                int money = resultSet.getInt("money");

                account.setCardNo(cardNo);
                account.setName(name);
                account.setMoney(money);
            }

            System.out.println(account);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
