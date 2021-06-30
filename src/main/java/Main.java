import com.ua.foxminded.school.dao.DataSource;
import com.ua.foxminded.school.dao.impl.CourseDaoImpl;
import com.ua.foxminded.school.dao.impl.GroupDaoImpl;
import com.ua.foxminded.school.dao.impl.StudentDaoImpl;
import com.ua.foxminded.school.dao.mapper.CourseMapper;
import com.ua.foxminded.school.dao.mapper.GroupMapper;
import com.ua.foxminded.school.dao.mapper.StudentMapper;
import com.ua.foxminded.school.menu.Composite;
import com.ua.foxminded.school.menu.component.StudentComponent;
import com.ua.foxminded.school.menu.component.StudentDeleter;
import com.ua.foxminded.school.menu.component.StudentInserter;
import com.ua.foxminded.school.model.Group;
import com.ua.foxminded.school.service.SchoolCombiner;
import com.ua.foxminded.school.service.creator.CourseDataCreator;
import com.ua.foxminded.school.service.creator.GroupDataCreator;
import com.ua.foxminded.school.service.creator.StudentDataCreator;
import com.ua.foxminded.school.service.inserter.CourseDataInserter;
import com.ua.foxminded.school.service.inserter.GroupDataInserter;
import com.ua.foxminded.school.service.inserter.StudentDataInserter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GroupDataCreator groupDataCreator = new GroupDataCreator(10);
        List<Group> groupList = groupDataCreator.generateData();
        SchoolCombiner combiner = new SchoolCombiner(
                new StudentDataInserter(
                        new StudentDataCreator(10, groupList),
                        new StudentDaoImpl(new DataSource(), new StudentMapper()),
                        new CourseDaoImpl(new DataSource(), new CourseMapper())
                ),
                new GroupDataInserter(groupList, new GroupDaoImpl(
                        new DataSource(),
                        new GroupMapper()
                )),
                new CourseDataInserter(new CourseDataCreator(), new CourseDaoImpl(
                        new DataSource(),
                        new CourseMapper()
                ))
        );
        combiner.combine();
        Composite composite = new Composite();
        StudentComponent studentComponent = new StudentComponent();
        studentComponent.addComponent(new StudentInserter());
        studentComponent.addComponent(new StudentDeleter());
        composite.addComponent(studentComponent);
        composite.execute();
    }
}
