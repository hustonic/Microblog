CREATE TABLE message
(
    msg_id        BIGINT AUTO_INCREMENT COMMENT '私信ID',
    user_id_send  BIGINT COMMENT '发送方ID',
    user_id_rec   BIGINT COMMENT '接收方ID',
    msg_type      TINYINT COMMENT '私信类型',
    msg_text      TEXT COMMENT '私信文本',
    res_id        BIGINT COMMENT '资源ID',
    msg_send_time DATETIME COMMENT '消息发送时间',
    PRIMARY KEY (msg_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  DEFAULT CHARSET = utf8 COMMENT '私信';