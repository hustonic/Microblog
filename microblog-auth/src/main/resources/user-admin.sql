INSERT INTO `microblog_user`.`user` (`user_name`, `user_name_set_time`, `user_name_update_times`, `user_email`, `user_password`, `user_intro`, `user_cre_time`, `user_avail_time`)
VALUES ('admin1', now(), '0', 'huxiantao-cn@foxmail.com', '{bcrypt}$2a$10$R/eb3NvHHFUgetaWWdbNuexiKWHs6nqFtm4L36dKiHt8iMQbuxQtK', '管理员', now(), now());

INSERT INTO `microblog_user`.`user_role` (`user_id`, `role_id`) VALUES (LAST_INSERT_ID(), '10000');
