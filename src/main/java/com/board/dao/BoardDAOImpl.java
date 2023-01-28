package com.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;

// DAO�� Ưȭ�� ������̼�. @Component ������̼��� �ᵵ ��� ������, DAO Ŭ�����鿡 @Repository ������̼��� ��������ν�
// @Component ������̼��� ���� Ư���� �Բ�, DAO�� �޼ҵ忡�� �߻��� �� �ִ� unchecked exception���� �������� DataAccessException����
// ó���� �� �ִ� ���� ���� ���´�.
@Repository
public class BoardDAOImpl implements BoardDAO {

//	name���� DI�� ������ �Ѵ�. �ڹٿ��� �����ϴ� ������̼��̸� �����ӿ�ũ�� ���������� �ʾ� �����ص� ����.
//	Ÿ������ �����Ѵ�.
	@Inject
	private SqlSession sql;

	private static String namespace = "com.board.mappers.board";

	// �Խù� ���
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".list");
	}

	// �Խù� �ۼ�
	@Override
	public void write(BoardVO vo) throws Exception {
		
		sql.insert(namespace + ".write", vo);
		
	}
	
	//�Խù� ��ȸ
	@Override
	public BoardVO view(int bno) throws Exception {
		return sql.selectOne(namespace + ".view", bno);
	}
	
	@Override
	public void modify(BoardVO vo) throws Exception {
		sql.update(namespace + ".modify", vo);
	}
	
}