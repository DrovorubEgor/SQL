package com.ua.foxminded.school.service.creator;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.ua.foxminded.school.model.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GroupDataCreator implements DataCreator<Group> {

    private final FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
    private final List<Group> groups = new ArrayList<>();
    private final int groupAmount;

    public GroupDataCreator(int groupAmount) {
        this.groupAmount = groupAmount;
    }

    @Override
    public List<Group> generateData() {
        for (int counter = 0; counter < groupAmount; ++counter) {
            groups.add(new Group(fakeValuesService.bothify("??-##")));
        }
        return groups;
    }
}
