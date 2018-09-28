package cn.merryyou.editor.editor.repository;

import cn.merryyou.editor.editor.domain.Editor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EditorRepository extends JpaRepository<Editor, Integer> {
}
