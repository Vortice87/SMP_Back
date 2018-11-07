package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.Comment;

/**
 * The Interface CommentDao.
 */
public interface CommentDao extends CrudRepository<Comment, Integer>{

}
