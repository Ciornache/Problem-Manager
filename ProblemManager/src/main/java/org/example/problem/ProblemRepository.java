package org.example.problem;

import java.util.List;

public interface ProblemRepository {
    void addItem(Problem problem);
    void deleteItem(Problem problem);
    void updateItem(Problem problem, int id);
    List<Problem> selectAll();
    Problem findById(int id);
    Problem findByName(int id);

}
