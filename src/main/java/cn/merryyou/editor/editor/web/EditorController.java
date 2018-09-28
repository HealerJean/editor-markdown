package cn.merryyou.editor.editor.web;

import cn.merryyou.editor.editor.domain.Editor;
import cn.merryyou.editor.editor.domain.Result;
import cn.merryyou.editor.editor.service.EditorService;
import cn.merryyou.editor.editor.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Desc:  markdown 文件编辑和保存
 * @Date:  2018/9/28 上午10:47.
 */

@Controller
@RequestMapping("/editorWeb")
@Slf4j
public class EditorController {

    @Autowired
    private EditorService editorService;

    @PostMapping
    @ResponseBody
    public Result saveEditor(Editor editor) {
        log.info(editor.toString());
        editorService.save(editor);
        return ResultUtil.success();
    }

    /**
     * 预览
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/preview/{id}")
    public ModelAndView preview(@PathVariable(value = "id") int id, Map map) {

        Editor editor = editorService.findOne(id);

        map.put("editor", editor);
        return new ModelAndView("preview", map);
    }

    /**
     * 编辑
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") int id, Map map) {

        Editor editor = editorService.findOne(id);

        map.put("editor", editor);
        return new ModelAndView("index", map);
    }
}
