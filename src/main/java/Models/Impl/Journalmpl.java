package Models.Impl;

import Models.Intf.Journal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"classNumber", "classLiter", "entities"})
public class Journalmpl implements Journal {

    private static final Logger logger = LogManager.getLogger(Journalmpl.class);

    private int classNumber;
    private String classLiter;
    private List<EntityImpl> entities = new ArrayList<>();

    public Journalmpl() {
    }

    public Journalmpl(int classNumber, String classLiter) {
        this.classNumber = classNumber;
        this.classLiter = classLiter;
    }

    @XmlAttribute
    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @XmlAttribute
    public String getClassLiter() {
        return classLiter;
    }

    public void setClassLiter(String classLiter) {
        this.classLiter = classLiter;
    }

    @Override
    @XmlElement(name = "Entity")
    @XmlElementWrapper(name = "Entities")
    public List<EntityImpl> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<EntityImpl> entities) {
        this.entities = entities;
    }

    @Override
    public void addEntityStudent(String fio) {
        if (getEntityByFIO(fio) == null) {
            this.entities.add(new EntityImpl(fio));
            logger.info("Запись добавлена: ученик - " + fio);
        } else logger.warn("Такой ученик уже есть!");
    }

    @Override
    public void addFullEntity(String fio, List<AssesmentImpl> assesments) {
        this.entities.add(new EntityImpl(fio, assesments));
        logger.info("Запись добавлена: ученик - " + fio + ", оценки - " + assesments);
    }

    @Override
    public EntityImpl getEntityByFIO(String fio) {
        logger.info("Выполняется поиск оценок ученика: " + fio);
        for (EntityImpl e : this.entities) {
            if (e.getFIO().equals(fio)) {
                logger.info("Записи найдены!");
                return e;
            }
        }
        logger.info("Записи не найдены");
        return null;
    }

    @Override
    public void deleteInlying(String name) {
        logger.info("Выполняется поиск в журнале ученика: " + name + "...");
        for (EntityImpl e : entities) {
            if (e.getFIO().equals(name)) {
                logger.info("Ученик найден");
                entities.remove(e);
                logger.info("Запись удалена");
            }
        }
    }

    @Override
    public String toString() {
        return getClassNumber() + getClassLiter();
    }
}
