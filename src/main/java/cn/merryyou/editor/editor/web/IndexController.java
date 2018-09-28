package cn.merryyou.editor.editor.web;

import cn.merryyou.editor.editor.domain.Editor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Desc: 打开Markdown编辑器
 * @Date:  2018/9/28 上午10:48.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index(Map map) {
        ModelAndView mav = new ModelAndView();

        map.put("editor", new Editor());
        return new ModelAndView("index", map);
    }
}
