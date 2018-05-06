package Models.Intf;

import Models.Impl.AssesmentImpl;
import Models.Impl.EntityImpl;

import java.util.List;

public interface Journal extends Deletable {


    List<EntityImpl> getEntities();

    void setEntities(List<EntityImpl> entities);

    void addEntityStudent(String fio);

    void addFullEntity(String fio, List<AssesmentImpl> assesments);

    EntityImpl getEntityByFIO(String fio);
}
