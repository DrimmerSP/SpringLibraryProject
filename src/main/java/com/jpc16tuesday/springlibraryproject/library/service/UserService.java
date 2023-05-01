package com.jpc16tuesday.springlibraryproject.library.service;

import com.jpc16tuesday.springlibraryproject.library.dao.UserDAO;
import com.jpc16tuesday.springlibraryproject.library.model.Book;
import com.jpc16tuesday.springlibraryproject.library.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public User saveUserDB(User user ){
        return userDAO.save(user);
    }

    public List<Book> getBookListFromUserByEMail(String emailUser){
        return userDAO.getUserByEmail(emailUser).orElseThrow().getBooks();
    }
}
