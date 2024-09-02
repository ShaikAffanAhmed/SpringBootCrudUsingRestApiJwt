package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.PropertyGroup;
import com.app.service.PropertyGroupService;

@RestController
@RequestMapping("/api/propertyGroup")
public class PropertyGroupController {

	@Autowired
	private PropertyGroupService groupService;

	@PostMapping("/create")
	public PropertyGroup createGroup(@RequestBody PropertyGroup propertyGroup) {
		return groupService.save(propertyGroup);
	}

	@GetMapping("/fetchAll")
	public List<PropertyGroup> getAllPropertyGroup() {
		return groupService.findAll();
	}

	@PutMapping("/update/{id}")
	public PropertyGroup updatePropertyGroup(@PathVariable Integer id, @RequestBody PropertyGroup propertyGroup) {
		propertyGroup.setPropertyGroupId(id);
		return groupService.save(propertyGroup);
	}

	@DeleteMapping("/delete/{id}")
	public String deletePropertyGroup(@PathVariable Integer id) {
		return groupService.deletebyId(id);
		
	}
}
