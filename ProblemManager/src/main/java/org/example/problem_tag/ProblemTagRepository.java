package org.example.problem_tag;

import java.util.List;

public interface ProblemTagRepository {
    void addItem(ProblemTag problemTag);
    void deleteItem(ProblemTag problemTag);
    void updateItem(ProblemTag problemTag, int id);
    List<ProblemTag> selectAll();
    ProblemTag findById(int id);
    ProblemTag findByName(int id);

}
