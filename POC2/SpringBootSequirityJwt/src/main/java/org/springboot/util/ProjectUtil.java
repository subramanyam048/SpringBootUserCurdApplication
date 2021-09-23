package org.springboot.util;

import java.util.Arrays;
import java.util.List;

import org.springboot.entity.Project;

public class ProjectUtil {

	public static final List<Project> getProjectList() {
		Project project1 = new Project("1", "spring", "1month");
		Project project2 = new Project("2", "maven", "2month");
		Project project3 = new Project("3", "hiberanate", "3month");
		return Arrays.asList(project1, project2, project3);
	}

}
