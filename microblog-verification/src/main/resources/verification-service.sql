CREATE TABLE verification (
	ver_id BIGINT AUTO_INCREMENT COMMENT '认证信息ID',
	ver_type TINYINT COMMENT '认证类型',
	ver_desc VARCHAR(100) COMMENT '认证描述',
	ver_real_name VARCHAR(30) COMMENT '真实姓名',
	ver_identity_card VARCHAR(18) COMMENT '身份证号',
	ver_state TINYINT COMMENT '认证状态',
	ver_res_desc VARCHAR(255) COMMENT '认证结果描述',
	ver_time DATETIME COMMENT '认证时间',
	user_id BIGINT COMMENT '用户ID',
	PRIMARY KEY (ver_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '认证信息';

ALTER TABLE verification ADD UNIQUE INDEX idx_user_id (user_id);

CREATE TABLE verification_picture (
	ver_pic_id BIGINT AUTO_INCREMENT COMMENT '认证图片ID',
	ver_id BIGINT COMMENT '认证信息ID',
	res_id BIGINT COMMENT '图片资源ID',
	PRIMARY KEY (ver_pic_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '认证图片';