CREATE TABLE relation (
	rela_id BIGINT AUTO_INCREMENT COMMENT '用户关系ID',
	user_id_sub BIGINT COMMENT '关注者ID',
	user_id_pub BIGINT COMMENT '被关注者ID',
	rela_remark VARCHAR(30) COMMENT '备注',
	rela_cre_time DATETIME COMMENT '关注时间',
	PRIMARY KEY (rela_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '用户关系';

ALTER TABLE relation ADD UNIQUE INDEX idx_user_id_sub_user_id_pub(user_id_sub, user_id_pub);


CREATE TABLE relation_group (
	rela_grp_id BIGINT AUTO_INCREMENT COMMENT '用户关系分组ID',
	rela_id BIGINT COMMENT '用户关系ID',
	group_id BIGINT COMMENT '分组ID',
	PRIMARY KEY (rela_grp_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '用户关系分组';


CREATE TABLE `group` (
	group_id BIGINT AUTO_INCREMENT COMMENT '分组ID',
	group_name VARCHAR(30) COMMENT '分组名称',
	group_desc VARCHAR(255) COMMENT '分组描述',
	user_id BIGINT COMMENT '分组所属的用户',
	PRIMARY KEY (group_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '分组';