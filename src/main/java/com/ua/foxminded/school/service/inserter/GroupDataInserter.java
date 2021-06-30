package com.ua.foxminded.school.service.inserter;

import com.ua.foxminded.school.dao.impl.GroupDao;
import com.ua.foxminded.school.model.Group;

import java.util.List;

public class GroupDataInserter implements DataInserter{

    private final List<Group> groups;
    private final GroupDao groupDao;

    public GroupDataInserter(List<Group> groups, GroupDao groupDao) {
        this.groups = groups;
        this.groupDao = groupDao;
    }

    @Override
    public void insert() {
        for (Group group : groups) {
            groupDao.insert(group);
        }
    }
}
