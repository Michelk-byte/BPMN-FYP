package org.example.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CamundaConstants {
    public static ArrayList<ArrayList<String>> projects = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Web Application", "3", "0")),
            new ArrayList<>(Arrays.asList("Blockchain", "2", "0"))
    ));

    public static StringBuilder printArrayOfArray(ArrayList<ArrayList<String>> projects) {
        StringBuilder projectsString = new StringBuilder();
        projectsString.append("[ ");
        for (List<String> project : CamundaConstants.projects) {
            projectsString.append(project.toString());
        }
        projectsString.append("] ");
        return projectsString;
    }
}
