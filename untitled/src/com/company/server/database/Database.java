package com.company.server.database;

import com.company.server.*;

import java.util.ArrayList;
import java.util.List;


public interface Database {
public List<User> USERS = new ArrayList<>();
public List<Subject> SUBJECTS = new ArrayList<>();
public List<UserTestSolveHistory> USER_TEST_SOLVE_HISTORIES = new ArrayList<>();
public List<Question> QUESTIONS = new ArrayList<>();
public List<Object> DELETED = new ArrayList<>();


}
