package Models.Impl;

import Models.Intf.Instance;
import Models.Intf.Subject;
import Services.Parser.Impl.JAXBParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlType(name = "Subjects")
public class InstanceImpl implements Instance {

    private static final Logger logger = LogManager.getLogger(Journalmpl.class);
    private static String filepath = "D:/subjects.xml";

    private List<SubjectImpl> subjects = new ArrayList<>();
    private static JAXBParser parser = new JAXBParser();
    private static volatile InstanceImpl instance;


    public static Instance getInstance() {
        Instance localInstance = instance;
        if (localInstance == null) {
            synchronized (InstanceImpl.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = (InstanceImpl) (localInstance = new InstanceImpl());
                }
            }
        }
        return localInstance;
    }

    @Override
    @XmlElement(name = "Subject")
    @XmlElementWrapper(name = "Subjects")
    public List<SubjectImpl> getSubjects() {
        return subjects;
    }

    @Override
    public void setSubjects(List<SubjectImpl> subjects) {
        this.subjects = subjects;
    }

    @Override
    public void addSubject(String subjectName) {
        if (getSubjectByName(subjectName) == null) {
            subjects.add(new SubjectImpl(subjectName));
            logger.info("Был добавлен предмет - " +
                    subjectName);
        } else logger.warn("Такой предмет уже есть!");
    }

    @Override
    public Subject getSubjectByName(String subjectName) {
        logger.info("Выполняется поиск предмета: " + subjectName + "...");
        for (SubjectImpl s : this.subjects) {
            if (s.getSubjectName().equals(subjectName)) {
                logger.info("Предмет найден!");
                return s;
            }
        }
        logger.info("Предмет не найден");
        return null;
    }

    @Override
    public void saveInstanceToFile() {
        try {
            parser.writeFile(filepath, instance);
        } catch (NullPointerException exc) {
            logger.error("Файл не загружен!");
        }
    }

    @Override
    public void readFile() {
        instance = (InstanceImpl) parser.readFile(filepath, InstanceImpl.class);
    }

    @Override
    public void deleteInlying(String name) {
        logger.info("Выполняется поиск предмета: " + name + "...");
        for (SubjectImpl s : this.subjects) {
            if (s.getSubjectName().equals(name)) {
                logger.info("Предмет найден!");
                subjects.remove(s);
                logger.info("Предмет " + name + "удален");
            }
        }
    }



}
