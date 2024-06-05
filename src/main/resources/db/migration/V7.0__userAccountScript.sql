INSERT INTO user_account(id,active,password,user_name,role_id) VALUES 
(1,true,'1234','admin',1);
update user_account_seq set next_val=2;