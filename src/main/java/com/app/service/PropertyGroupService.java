package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.PropertyGroup;
import com.app.repository.PropertyGroupRepository;

@Service
public class PropertyGroupService {

	@Autowired
	private PropertyGroupRepository groupRepository;

	// create
	public PropertyGroup save(PropertyGroup propertyGroup) {
		return groupRepository.save(propertyGroup);
	}

	// fetch
	public List<PropertyGroup> findAll() {
		return groupRepository.findAll();
	}

	// update
	public PropertyGroup update(Integer id, PropertyGroup propertyGroup) {
		if (groupRepository.existsById(id)) {
			propertyGroup.setPropertyGroupId(id);
			return groupRepository.save(propertyGroup);
		} else {
			throw new RuntimeException("PropertyGroup not found with id " + id);
		}
	}

	// delete
	public void deletebyId(Integer id) {
		groupRepository.deleteById(id);
	}
}
