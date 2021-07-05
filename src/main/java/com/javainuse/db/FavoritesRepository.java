package com.javainuse.db;

import com.javainuse.model.Favorites;
import com.javainuse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {

    @Modifying
    @Transactional
    @Query(value="Delete from favorites a where a.book_id= :bookId and a.user_name= :userName", nativeQuery=true)
    void deleteByBookId(@Param("bookId") long bookId, @Param("userName") String userName);
}
