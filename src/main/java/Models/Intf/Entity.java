package Models.Intf;

import Models.ENUM.AssesmentEn;

import java.util.Date;

public interface Entity {

    void deleteAssesment(int count);

    void addAssesment(AssesmentEn assesment, Date date);
}
