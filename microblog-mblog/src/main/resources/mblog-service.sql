CREATE TABLE microblog (
	mblog_id BIGINT AUTO_INCREMENT COMMENT '微博ID',
	mblog_text TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '文本',
	mblog_type TINYINT COMMENT '微博类型',
	mblog_id_forward BIGINT COMMENT '转发的微博ID',
	mblog_pub_time DATETIME COMMENT '微博发布时间',
	user_id BIGINT COMMENT '发布者',
	PRIMARY KEY (mblog_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '微博';


CREATE TABLE agree_microblog (
	agree_id BIGINT AUTO_INCREMENT COMMENT '点赞记录ID',
	user_id BIGINT COMMENT '点赞者ID',
	mblog_id BIGINT COMMENT '被点赞的微博ID',
	agree_time DATETIME COMMENT '点赞时间',
	PRIMARY KEY (agree_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '点赞微博';

ALTER TABLE agree_microblog ADD UNIQUE INDEX idx_user_id_mblog_id (user_id, mblog_id);


CREATE TABLE collect (
	collect_id BIGINT AUTO_INCREMENT COMMENT '收藏记录ID',
	user_id BIGINT COMMENT '收藏者ID',
	mblog_id BIGINT COMMENT '被收藏的微博ID',
	collect_time DATETIME COMMENT '收藏时间',
	PRIMARY KEY (collect_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '收藏微博';

ALTER TABLE collect ADD UNIQUE INDEX idx_user_id_mblog_id (user_id, mblog_id);


CREATE TABLE microblog_resource (
	mblog_res_id BIGINT AUTO_INCREMENT COMMENT '微博资源关系ID',
	mblog_id BIGINT COMMENT '微博ID',
	res_id BIGINT COMMENT '资源ID',
	PRIMARY KEY (mblog_res_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '微博资源';