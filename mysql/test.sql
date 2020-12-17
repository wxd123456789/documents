--... mysql -u root -p ******
--mall table
USE mall;
SELECT * FROM ums_role;
--copy table
CREATE TABLE ums_role_copy SELECT * FROM ums_role;
SELECT * FROM ums_role_copy;
--将语句的结束符号从分号;临时改为两个$$
--使得过程体使用的分号被直接传递到服务器，而不会被客户端mysql解释。
delimiter $$
--create procedure
CREATE PROCEDURE delete_call(IN n_admin_count INTEGER)\
BEGIN\
DELETE FROM ums_role_copy WHERE admin_count = n_admin_count;\
END$$\
--恢复结束符号从分号;
delimiter ;
--query procedure
SHOW PROCEDURE STATUS WHERE db='mall' \G;
SHOW  CREATE PROCEDURE mall.delete_call \G;
--use procedure
CALL delete_call(1);
SELECT * FROM ums_role_copy;
