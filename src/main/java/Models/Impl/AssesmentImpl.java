package Models.Impl;

import Models.ENUM.AssesmentEn;
import Models.Intf.Assesment;
import Services.Parser.MyDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlType
public class AssesmentImpl implements Assesment {

    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private Date date;
    private AssesmentEn assesment;

    public AssesmentImpl() {
    }

    public AssesmentImpl(Date date, AssesmentEn assesment) {
        this.date = date;
        this.assesment = assesment;
    }

    @XmlElement(name = "Date")
    @XmlJavaTypeAdapter(MyDateAdapter.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlElement(name = "Assesment")
    public AssesmentEn getAssesment() {
        return assesment;
    }

    public void setAssesment(AssesmentEn assesment) {
        this.assesment = assesment;
    }

    @Override
    public String toString() {
        return "{\"" + getAssesment().toString() + "\" - " + dateFormat.format(getDate()) + "}";
    }
}
