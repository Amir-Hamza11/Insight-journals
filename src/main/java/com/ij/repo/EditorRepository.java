package com.ij.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ij.entity.Editor;

public interface EditorRepository extends JpaRepository<Editor, Long> {

	public Editor findByEditor(String editor);
}
