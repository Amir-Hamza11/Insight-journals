package com.ij.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ij.entity.Editor;
import com.ij.entity.News;
import com.ij.service.EditorService;

@RestController
@RequestMapping("/editor")
@CrossOrigin("*")
public class EditorController {

	@Autowired
	private EditorService editorService;

//	@GetMapping("/{id}")
//	public ResponseEntity<Editor> getCustomerById(@PathVariable Long id) {
//		Editor editor = editorService.getEditor(id);
//
//		if (editor == null) {
//			return ResponseEntity.notFound().build();
//		} else
//			return ResponseEntity.ok(editor);
//	}
	
	@GetMapping("/{user}")
	public Editor getNewsByCategory(@PathVariable String user)
	{
		return editorService.getEditorByUser(user);
	}
	

}
