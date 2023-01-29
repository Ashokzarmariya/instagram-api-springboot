package com.zos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zos.model.Comments;


public interface CommentRepository extends JpaRepository<Comments, Integer> {

}
