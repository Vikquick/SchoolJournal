package Services.Parser;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateAdapter extends XmlAdapter<String, Date> {
    private static final ThreadLocal<DateFormat> dateFormat
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    @Override
    public Date unmarshal(String date) throws Exception {
        return dateFormat.get().parse(date);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return dateFormat.get().format(date);
    }
}