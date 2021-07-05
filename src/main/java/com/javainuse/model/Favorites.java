package com.javainuse.model;


import javax.persistence.*;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Entity
@Table(name = "favorites")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "bookId")
    private Long bookId;


    @Column(name = "userName")
    private String userName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        LOGGER.info("worked2");
        this.bookId = bookId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        LOGGER.info("worked1");
        this.userName = userName;
    }



}
