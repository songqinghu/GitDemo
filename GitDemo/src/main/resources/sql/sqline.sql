--添加字段再指定字段后
alter table `prepic` Add column count bigint not null default 0 AFTER `flag`;
--添加索引字段
ALTER TABLE table_name ADD INDEX index_name (column_list)