package com.kh.template.template.template.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TemplateMapper {
    @Select("""
        SELECT html
        FROM TB_TEMPLATE
        WHERE template = #{template}
    """)
    String selectTemplate(String template);

    @Update("""
        UPDATE TB_TEMPLATE
        SET HTML = #{html}
        ,UPD_DT = SYSDATE
        WHERE TEMPLATE = #{template}
    """)
    void updateTemplate(String template, String html);

    @Insert("""
      INSERT INTO TB_TEMPLATE (
        TEMPLATE
        , HTML
      ) VALUES (
          #{template}
          , #{html}
      )
    """)
    void insertTemplate(String template, String html);
@Select("""
    SELECT COUNT(*) 
    FROM TB_TEMPLATE
    WHERE TEMPLATE = #{template}
""")
    int countTemplate(String template);
}
