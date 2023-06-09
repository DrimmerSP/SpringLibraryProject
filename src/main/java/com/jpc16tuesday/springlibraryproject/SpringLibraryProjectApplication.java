package com.jpc16tuesday.springlibraryproject;


import com.jpc16tuesday.springlibraryproject.dbexample.MyDBConfigContext;
import com.jpc16tuesday.springlibraryproject.dbexample.dao.BookDAOBean;
import com.jpc16tuesday.springlibraryproject.dbexample.dao.BookDaoJDBC;
import com.jpc16tuesday.springlibraryproject.dbexample.db.DBConnection;
import com.jpc16tuesday.springlibraryproject.library.model.Role;
import com.jpc16tuesday.springlibraryproject.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.time.LocalDate;


@SpringBootApplication
public class SpringLibraryProjectApplication implements CommandLineRunner {

//    private BookDAOBean bookDAOBean;

    //Инжект бина через конструктор
//    public SpringLibraryProjectApplication(BookDAOBean bookDAOBean) {
//        this.bookDAOBean = bookDAOBean;
//    }

    //Инжект бина через сеттер (сеттер может иметь разное название)
//    @Autowired
//    public void setSomething(BookDAOBean bookDAOBean) {
//        this.bookDAOBean = bookDAOBean;
//    }
    //JDBC обертка от спринга (зависимость spring-boot-starter-jdbc)
//    @Autowired
//    private NamedParameterJdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringLibraryProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        //Шаг 1 (Большая связность кода)
//        BookDaoJDBC bookDaoJDBC = new BookDaoJDBC();
//        bookDaoJDBC.findBookById(3);
//
//        //Шаг 2 (Сделали BookDaoBean - добавили поле connection)
//        BookDAOBean bookDAOBean = new BookDAOBean(DBConnection.INSTANCE.newConnection());
//        bookDAOBean.findBookById(2);
//
//        //Шаг 3 - Работаем с Spring Context
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyDBConfigContext.class);
//        BookDAOBean bookDAOBean = ctx.getBean(BookDAOBean.class);
//        bookDAOBean.findBookById(3);

        //Шаг 4 - для MyDBConfigContext добавляем аннотацию @ComponentScan, удаляем связь на BookDAOBean
        //Добавляем аннотацию @Component для BookDAOBean (на 3 шаги был без аннотации)

        //Финальный шаг
//        bookDAOBean.findBookById(3);

        //JDBC обертка от спринга (зависимость spring-boot-starter-jdbc) -> работа с темплейтом
//        List<Book> bookList = jdbcTemplate.query("select * from books",
//                ((rs, rowNum) -> new Book(
//                        rs.getInt("id"),
//                        rs.getString("title"),
//                        rs.getString("author"),
//                        rs.getDate("date_added")
//                )));
//        bookList.forEach(System.out::println);
    }
}
