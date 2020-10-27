CREATE TABLE accuse_user
(
    accu_user_id    BIGINT AUTO_INCREMENT COMMENT '举报用户记录ID',
    user_id_accuse  BIGINT COMMENT '举报用户ID',
    user_id_accused BIGINT COMMENT '被举报的用户ID',
    accu_desc       VARCHAR(255) COMMENT '举报描述',
    accu_time       DATETIME COMMENT '举报时间',
    PRIMARY KEY (accu_user_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  DEFAULT CHARSET = utf8 COMMENT '举报用户';


CREATE TABLE accuse_message
(
    accu_msg_id BIGINT AUTO_INCREMENT COMMENT '举报私信记录ID',
    user_id     BIGINT COMMENT '举报者ID',
    msg_id      BIGINT COMMENT '被举报的私信ID',
    accu_desc   VARCHAR(255) COMMENT '举报描述',
    accu_time   DATETIME COMMENT '举报时间',
    PRIMARY KEY (accu_msg_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  DEFAULT CHARSET = utf8 COMMENT '举报私信';


CREATE TABLE accuse_microblog
(
    accu_mblog_id BIGINT AUTO_INCREMENT COMMENT '举报微博记录ID',
    user_id       BIGINT COMMENT '举报者ID',
    mblog_id      BIGINT COMMENT '被举报的微博ID',
    accu_desc     VARCHAR(255) COMMENT '举报描述',
    accu_time     DATETIME COMMENT '举报时间',
    PRIMARY KEY (accu_mblog_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  DEFAULT CHARSET = utf8 COMMENT '举报微博';


CREATE TABLE accuse_comment
(
    accu_comm_id BIGINT AUTO_INCREMENT COMMENT '评论举报记录ID',
    user_id      BIGINT COMMENT '举报者ID',
    comm_id      BIGINT COMMENT '被举报的评论ID',
    accu_desc    VARCHAR(255) COMMENT '举报描述',
    accu_time    DATETIME COMMENT '举报时间',
    PRIMARY KEY (accu_comm_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  DEFAULT CHARSET = utf8 COMMENT '举报评论';