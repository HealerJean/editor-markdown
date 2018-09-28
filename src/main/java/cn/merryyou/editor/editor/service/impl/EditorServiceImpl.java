package cn.merryyou.editor.editor.service.impl;

import cn.merryyou.editor.editor.domain.Editor;
import cn.merryyou.editor.editor.repository.EditorRepository;
import cn.merryyou.editor.editor.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EditorServiceImpl implements EditorService {

    @Autowired
    private EditorRepository repository;


    @Override
    public void save(Editor editor) {
        repository.save(editor);
    }

    @Override
    public Editor findOne(int id) {
        return repository.findOne(id);
    }
}
