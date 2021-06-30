package com.ua.foxminded.school.dao.impl;

import com.ua.foxminded.school.dao.Dao;
import com.ua.foxminded.school.model.Group;

public interface GroupDao extends Dao<Group> {
    Group getGroupByName(String groupName);
}
