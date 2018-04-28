package Models.Impl;


import Models.Intf.Subject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "SubjectImpl")
public class SubjectImpl implements Subject {
    private static final Logger logger = LogManager.getLogger(SubjectImpl.class);

    private String subjectName;
    private List<Journalmpl> journals = new ArrayList<>();

    public SubjectImpl() {
    }

    public SubjectImpl(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    @XmlElement(name = "Journal")
    @XmlElementWrapper(name = "Journals")
    public List<Journalmpl> getJournals() {
        return journals;
    }

    @Override
    public void setJournals(List<Journalmpl> journals) {
        this.journals = journals;
    }

    @XmlAttribute
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public void createJournal(int classNumber, String classLiter) {
        try {
            if (getJournalByClass(classNumber, classLiter) == null) {
                this.journals.add(new Journalmpl(classNumber, classLiter));
                logger.info("Добавлен журнал для " +
                        classNumber + " " + classLiter + " по предмету " +
                        this.subjectName);
            } else logger.info("Такой журнал уже существует!");
        } catch (NullPointerException exc) {
            logger.warn("Такого предмета не существует");
        }
    }

    @Override
    public Journalmpl getJournalByClass(int classNumber, String classLiter) {
        logger.info("Выполняется поиск журнала по предемету " + this.subjectName + " для " + classNumber + " " + classLiter + " класса...");
        for (Journalmpl j : this.journals) {
            if (j.getClassLiter().equals(classLiter) && j.getClassNumber() == classNumber) {
                logger.info("Журнал найден!");
                return j;
            }
        }
        logger.info("Такой журнал не найден");
        return null;
    }

    @Override
    public void deleteInlying(int classNumber, String classLiter) {
        Journalmpl j = getJournalByClass(classNumber, classLiter);
        if (j != null) {
            journals.remove(j);
            logger.info("Журнал удален");
        }
    }

    @Override
    public String toString(){
        return getSubjectName();
    }
}
