package com.ij.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ij.entity.Editor;
import com.ij.repo.EditorRepository;

@Service
public class EditorService {
	
	@Autowired
	private EditorRepository editorRepository;
	
	
	//SAVE EDITOR:
//	public Editor postEditor(Editor editor) {
//		return editorRepository.save(editor);
//	}
	
	//GET EDITOR BY ID
//	public Editor getEditor(Long id) {
//
//		return editorRepository.findById(id).orElse(null);
//	}
	
	public Editor getEditorByUser(String user) {

		return editorRepository.findByEditor(user);
	}
}
