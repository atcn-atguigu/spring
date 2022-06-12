package com.atguigu.spring5.jdbctemplate.dao;

import com.atguigu.spring5.jdbctemplate.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    // dao类里注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 增删改：jdbcTemplate.(String sql, Object... args)
     */
    // 添加书籍
    public int add(Books books) {
        // 1. 创建sql语句, ?表示占位符，可被jdbcTemplate参数形式替换
        String sql = "INSERT INTO spring_book.t_books (bookName, bookCounts, detail) VALUE (?,?,?)";

        // 2。 调用方法实现，返回影响行数
        // 写法1.
//        int update = jdbcTemplate.update(sql, books.getBookName(), books.getBookCounts(), books.getDetail());

        // 写法2.
        Object[] args = {books.getBookName(), books.getBookCounts(), books.getDetail()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println("数据库INSERT添加操作，受影响的行数为：" + update);
        return update;
    }

    // 修改书籍
    public int update(Books books) {
        String sql = "UPDATE spring_book.t_books SET bookName=?, bookCounts=?, detail=? WHERE bookID=?";
        Object[] args = {books.getBookName(), books.getBookCounts(), books.getDetail(), books.getBookID()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println("数据库UPDATE更新操作，受影响的行数为：" + update);
        return update;
    }

    // 删除书籍
    public int delete(Books books) {
        String sql = "DELETE FROM spring_book.t_books WHERE bookID = ?";
        Object[] args = {books.getBookID()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println("数据库DELETE删除操作，受影响的行数为：" + update);
        return update;
    }

    /**
     * 查询表记录值：jdbcTemplate.queryForObject(String sql, Class<T> requiredType)
     * @return 值
     */
    // 查询表记录数
    public int queryTableCount() {
        String sql = "SELECT COUNT(*) FROM spring_book.t_books";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("数据库SELECT查询操作，queryTableCount()：" + count);
        return count;
    }

    /**
     * 查询一个书籍对象：jdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object... args)
     * @return 对象
     */
    // 通过书籍id查询书籍 - 最多返回一个值（书籍）
    public Books queryById(Books books) {
        String sql = "SELECT * FROM spring_book.t_books WHERE bookID=?";
        Object[] args = {books.getBookID()};
        RowMapper<Books> rowMapper = new BeanPropertyRowMapper<Books>(Books.class);
        Books book = jdbcTemplate.queryForObject(sql, rowMapper, args);
        System.out.println("数据库SELECT查询操作，queryById()");
        return book;
    }

    /**
     * 查询书籍集合
     * @return 集合
     */
    // 通过书籍name查询书籍 - 返回书籍集合
    public List<Books> queryByName(Books books) {
        String sql = "SELECT * FROM spring_book.t_books WHERE bookName=?";
        Object[] args = {books.getBookName()};
        RowMapper<Books> rowMapper = new BeanPropertyRowMapper<Books>(Books.class);
        List<Books> booksList = jdbcTemplate.query(sql, rowMapper, args);
        System.out.println("数据库SELECT查询操作，queryByName()");
        return booksList;
    }

    // 查询所有书籍 - 返回书籍集合
    public List<Books> queryAll() {
        String sql = "SELECT * FROM spring_book.t_books";
        RowMapper<Books> rowMapper = new BeanPropertyRowMapper<Books>(Books.class);
        List<Books> booksList = jdbcTemplate.query(sql, rowMapper);
        System.out.println("数据库SELECT查询操作，queryByName()");
        return booksList;
    }
}
