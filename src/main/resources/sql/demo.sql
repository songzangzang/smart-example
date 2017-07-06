/*权限建表语句*/
CREATE TABLE `user` (
 id bigint(20) NOT NULL ,
 username  varchar(25) NOT NULL ,
password  varchar(25) NOT NULL ,
PRIMARY KEY (`id`)
);

CREATE TABLE user_role(
	id bigint(20) NOT NULL,
	user_id bigint(20) NOT NULL,
	role_id bigint(20) NOT NULL
	PRIMARY KEY(id)
);

CREATE TABLE role(
	id bigint(20) NOT NULL,
	role_name varchar(25) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE role_permission(
	id bigint(20) NOT NULL,
	role_id bigint(20) NOT NULL,
	permission_id bigint(20) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE permission(
	id bigint(20) NOT NULL,
	permission_name varchar(25) NOT NULL,
	PRIMARY KEY(id)
);