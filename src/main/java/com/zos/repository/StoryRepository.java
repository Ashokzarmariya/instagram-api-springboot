package com.zos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zos.model.Story;

public interface StoryRepository extends JpaRepository<Story, Integer>{

}
