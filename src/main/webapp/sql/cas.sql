create table cas_pub_user(
    user_id  number(10),
    username varchar2(100),
    password varchar2(100),
    activity number(4)
);
insert into cas_pub_user(user_id,username,password,activity)
values(100,'zj','ok',1);
insert into cas_pub_user(user_id,username,password,activity)
values(101,'lp','ok',1);

create table cas_pub_role(
    role_id  number(10),
    role_code varchar2(100),
    role_name varchar2(100),
    activity number(4)
);
insert into cas_pub_role(role_id,role_code,role_name,activity)
values(1,'ROLE_ADMIN','����Ա',1);
insert into cas_pub_role(role_id,role_code,role_name,activity)
values(2,'ROLE_MANAGER','���ž���',1);
insert into cas_pub_role(role_id,role_code,role_name,activity)
values(3,'ROLE_COMMON','��ͨԱ��',1);


create table cas_pub_user_role(
user_id number(10),
role_id number(10)
);
insert into cas_pub_user_role(user_id,role_id)
values(100,1);
insert into cas_pub_user_role(user_id,role_id)
values(100,2);
insert into cas_pub_user_role(user_id,role_id)
values(100,3);
insert into cas_pub_user_role(user_id,role_id)
values(101,2);
insert into cas_pub_user_role(user_id,role_id)
values(101,3);

create table cas_pub_resource(
    resource_id number(10),
    resource_name varchar2(100),
    resource_url varchar2(100),
    activity number(4)
);
insert into cas_pub_resource(resource_id,resource_name,resource_url,activity)
values(1,'��¼ҳ��','/login.jsp',1);
insert into cas_pub_resource(resource_id,resource_name,resource_url,activity)
values(2,'����Աҳ��','/admin.jsp',1);
insert into cas_pub_resource(resource_id,resource_name,resource_url,activity)
values(3,'����ҳ��','/manager.jsp',1);
insert into cas_pub_resource(resource_id,resource_name,resource_url,activity)
values(4,'��ͨҳ��','/common.jsp',1);


create table cas_pub_role_resource(
   role_id number(10),
   resource_id number(10)
);
insert into cas_pub_role_resource(role_id,resource_id) values(1,1);
insert into cas_pub_role_resource(role_id,resource_id) values(1,2);
insert into cas_pub_role_resource(role_id,resource_id) values(1,3);
insert into cas_pub_role_resource(role_id,resource_id) values(1,4);

insert into cas_pub_role_resource(role_id,resource_id) values(2,1);
insert into cas_pub_role_resource(role_id,resource_id) values(2,3);
insert into cas_pub_role_resource(role_id,resource_id) values(2,4);

insert into cas_pub_role_resource(role_id,resource_id) values(3,1);
insert into cas_pub_role_resource(role_id,resource_id) values(3,4);
