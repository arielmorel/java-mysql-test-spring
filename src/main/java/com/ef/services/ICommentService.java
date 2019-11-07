package com.ef.services;

import com.ef.entities.Comment;

/**
 * @author Ariel Morel
 */
public interface ICommentService {

    /**
     * persist the comment object
     * @param comment class for persist the object
     */
    void saveComment(Comment comment );
}
