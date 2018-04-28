package Models.Intf;

import Models.Impl.SubjectImpl;

import java.util.List;

public interface Instance extends Deletable {

    List<SubjectImpl> getSubjects();

    void setSubjects(List<SubjectImpl> subjects);

    void addSubject(String subjectName);

    Subject getSubjectByName(String subjectName);

    void saveInstanceToFile();

    void readFile();
}
