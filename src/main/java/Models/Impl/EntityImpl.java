package Models.Impl;


import Models.ENUM.AssesmentEn;
import Models.Intf.Entity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlType(propOrder = {"FIO", "assesments"})
public class EntityImpl implements Entity {

    private static final Logger logger = LogManager.getLogger(EntityImpl.class);

    private String FIO;
    private List<AssesmentImpl> assesments = new ArrayList<>();

    public EntityImpl() {
    }

    public EntityImpl(String FIO) {
        this.FIO = FIO;
    }

    public EntityImpl(String FIO, List<AssesmentImpl> assesments) {
        this.FIO = FIO;
        this.assesments = assesments;
    }

    @XmlAttribute
    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @XmlElement(name = "Assesment")
    @XmlElementWrapper(name = "Assesments")
    public List<AssesmentImpl> getAssesments() {
        return assesments;
    }

    public void setAssesments(List<AssesmentImpl> assesments) {
        this.assesments = assesments;
    }

    @Override
    public void addAssesment(AssesmentEn assesment, Date date) {
        assesments.add(new AssesmentImpl(date, assesment));
        logger.info("Ученику " + FIO + " добавлена оценка " + assesment.toString() + " по Дате: '" + date + "'");
    }

    @Override
    public void deleteAssesment(int count) {
        getAssesments().remove(count-1);
        logger.info("Удалена оценка под номером: " + count);
    }

    @Override
    public String toString(){
        return getFIO();
    }
}
