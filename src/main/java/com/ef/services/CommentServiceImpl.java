package com.ef.services;

import com.ef.entities.Comment;
import com.ef.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ariel Morel
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void saveComment(Comment comment ){
        if(comment!=null){
            commentRepository.save(comment);
        }
    }
}
