package com.kh.template.template.api;

import com.kh.template.template.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/template")
@RequiredArgsConstructor
public class TemplateApiController {

    private final TemplateService templateService;

    @GetMapping("{template}")
    public String getTemplate(@PathVariable String template) {
        return templateService.getTemplate(template);
    }

    @PostMapping("{template}")
    public void saveTemplate(@PathVariable String template, @RequestBody String html) {
        templateService.saveTemplate(template,html);
    }

}
