package com.huston.microblog.comment.service.impl;

import com.huston.microblog.comment.mapper.CommentMapper;
import com.huston.microblog.comment.model.dto.InsertCommentDTO;
import com.huston.microblog.comment.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huxiantao-cn@foxmail.com
 */
@SpringBootTest
@Transactional
class CommentServiceImplTest {

    private CommentService commentService;
    private CommentMapper commentMapper;

    @Autowired
    CommentServiceImplTest(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }


    @Test
    void insertComment() {

    }

    @Test
    void deleteComment() {
    }

    @Test
    void listComment() {
    }

    @Test
    void countComment() {
    }
}