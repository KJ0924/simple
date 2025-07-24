package com.kh.template.template.service;

import com.kh.template.template.template.mapper.TemplateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TemplateService {
    private final TemplateMapper templateMapper;
    public String getTemplate(String template) {
        return templateMapper.selectTemplate(template);
    }

    public void saveTemplate(String template, String html) {
        if(templateMapper.countTemplate(template) > 0){
            templateMapper.updateTemplate(template, html);
        }else{
            templateMapper.insertTemplate(template,html);
        }

    }
}
