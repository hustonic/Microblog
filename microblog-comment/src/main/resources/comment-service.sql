CREATE TABLE `comment` (
	comm_id BIGINT AUTO_INCREMENT COMMENT '评论ID',
	comm_text TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '评论文本',
	res_id BIGINT COMMENT '资源ID',
	mblog_id BIGINT COMMENT '评论所属的微博ID',
	comm_id_parent BIGINT COMMENT '父评论ID',
	comm_cre_time DATETIME COMMENT '评论时间',
	user_id BIGINT COMMENT '评论发布者ID',
	PRIMARY KEY (comm_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '评论';


CREATE TABLE agree_comment (
	agree_id BIGINT AUTO_INCREMENT COMMENT '点赞评论记录ID',
	user_id BIGINT COMMENT '点赞者ID',
	comm_id BIGINT COMMENT '被点赞的评论ID',
	agree_time DATETIME COMMENT '点赞时间',
	PRIMARY KEY (agree_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '点赞评论';

ALTER TABLE agree_comment ADD UNIQUE INDEX idx_user_id_comm_id (user_id, comm_id);