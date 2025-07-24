package com.kh.template.board.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardMapper {
    @Insert("""
        INSERT INTO TB_BOARD(
            NO
            , JSON_DATA
        ) VALUES (
            SEQ_BOARD.NEXTVAL
            , #{json}
        )
    """)
    void insertBoard(String json);
    @Select("""
        SELECT MAX(NO)
        FROM TB_BOARD
    """)
    int lastInsertNo();
    @Select("""
        SELECT JSON_DATA
        FROM TB_BOARD
        WHERE NO = #{no}
        """)
    String selectBoard(String no);
    @Delete("""
        DELETE TB_BOARD
        WHERE NO = #{no}
    """)
    void deleteBoard(String no);
}
