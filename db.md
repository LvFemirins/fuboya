评论表：
```
create table comment
(
id bigint auto_increment primary key,
parent_id bigint not null,
type int not null,
commentator int not null,
gmt_create bigint not null,
gmt_modified bigint not null,
like_count bigint default 0,
content varchar(1024),
comment_count int default 0
)
```

手动把question表的id, creator。
user表的id。 
都从int改为bigint
