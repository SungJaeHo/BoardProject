insert into tb_board (title,content,writer)
	values('테스트 제목 1', '테스트 내용', '작성자');
	insert into tb_board (title,content,writer)
	values('테스트 제목 2', '테스트 내용', '작성자');
	insert into tb_board (title,content,writer)
	values('테스트 제목 3', '테스트 내용', '작성자');
	insert into tb_board (title,content,writer)
	values('테스트 제목 4', '테스트 내용', '작성자');
insert into tb_board (title,content,writer)
	values('테스트 제목 5', '테스트 내용', '작성자');

select
			bno, title, content, writer, regDate, viewCnt
		from tb_board
	;