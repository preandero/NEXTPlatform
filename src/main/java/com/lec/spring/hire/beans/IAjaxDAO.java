package com.lec.spring.hire.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IAjaxDAO {

	// 페이징용 SELECT
	// from : 몇번재 row 부터
	// pageRows : 몇개의 데이터(게시글)
	public List<HWriteDTO> selectFromRow(
			@Param("from") int from,
			@Param("pageRows") int pageRows
	);

	public int deleteByUid(int uid);

	// 전체글의 개수
	public int countAll();

}


                                                                          















