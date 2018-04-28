package Models.Intf;

import Models.Impl.Journalmpl;

import java.util.List;

public interface Subject {

    List<Journalmpl> getJournals();

    void setJournals(List<Journalmpl> journals);

    void createJournal(int classNumber, String classLiter);

    Journal getJournalByClass(int classNumber, String classLiter);

    void deleteInlying(int classNumber, String classLiter);
}
