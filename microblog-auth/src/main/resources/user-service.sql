CREATE TABLE user
(
    user_id                BIGINT AUTO_INCREMENT COMMENT '用户ID',
    user_name              VARCHAR(30) COMMENT '用户名',
    user_name_set_time     DATETIME COMMENT '用户名设置时间',
    user_name_update_times TINYINT COMMENT '用户名在今年内的修改次数',
    user_email             VARCHAR(50) COMMENT '邮箱',
    user_phone             VARCHAR(11) COMMENT '手机号',
    user_password          VARCHAR(100) COMMENT '密码',
    user_sex               TINYINT COMMENT '性别',
    user_birthday          DATE COMMENT '生日',
    user_intro             VARCHAR(70) COMMENT '简介',
    res_id                 BIGINT COMMENT '头像资源ID',
    user_cre_time          DATETIME COMMENT '注册时间',
    user_avail_time        DATETIME COMMENT '帐号可用的开始时间',
    PRIMARY KEY (user_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  DEFAULT CHARSET = utf8 COMMENT '用户信息';

ALTER TABLE user ADD UNIQUE INDEX idx_user_name(user_name);
ALTER TABLE user ADD UNIQUE INDEX idx_user_email(user_email);
ALTER TABLE user ADD UNIQUE INDEX idx_user_phone(user_phone);


CREATE TABLE user_role
(
    user_role_id BIGINT AUTO_INCREMENT COMMENT '用户角色ID',
    user_id      BIGINT COMMENT '用户ID',
    role_id      BIGINT COMMENT '角色ID',
    PRIMARY KEY (user_role_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  DEFAULT CHARSET = utf8 COMMENT '用户角色';


CREATE TABLE role
(
    role_id       BIGINT AUTO_INCREMENT COMMENT '角色ID',
    role_name     VARCHAR(30) COMMENT '角色名称',
    role_desc     VARCHAR(255) COMMENT '角色描述',
    role_cre_time DATETIME COMMENT '角色创建时间',
    PRIMARY KEY (role_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  DEFAULT CHARSET = utf8 COMMENT '角色';

ALTER TABLE role ADD UNIQUE INDEX idx_role_name(role_name);


CREATE TABLE role_permission
(
    role_perm_id BIGINT AUTO_INCREMENT COMMENT 'id',
    role_id      BIGINT COMMENT '角色ID',
    perm_id      BIGINT COMMENT '权限ID',
    PRIMARY KEY (role_perm_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci COMMENT '角色权限关系';


CREATE TABLE permission
(
    perm_id       BIGINT AUTO_INCREMENT COMMENT '权限ID',
    perm_name     VARCHAR(30) COMMENT '权限名称',
    perm_desc     VARCHAR(255) COMMENT '权限描述',
    perm_url      VARCHAR(255) COMMENT '权限许可的URL',
    perm_cre_time DATETIME COMMENT '权限创建时间',
    PRIMARY KEY (perm_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  DEFAULT CHARSET = utf8 COMMENT '权限';

ALTER TABLE permission ADD UNIQUE INDEX idx_perm_name(perm_name);

