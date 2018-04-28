import Models.Impl.InstanceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        InstanceImpl.getInstance().readFile();
        System.out.println(InstanceImpl.getInstance().getSubjectByName("Химия").getJournalByClass(11, "А").getEntityByFIO("Горшков Виктор Владимирович").getAssesments().toString());
        InstanceImpl.getInstance().saveInstanceToFile();
    }

}
