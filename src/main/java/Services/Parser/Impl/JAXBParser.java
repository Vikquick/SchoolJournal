package Services.Parser.Impl;

import Services.Parser.Intf.Parser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.*;
import java.io.File;

public class JAXBParser implements Parser {
    private static final Logger logger = LogManager.getLogger(JAXBParser.class);

    @Override
    public Object readFile(String filepath, Class c) {
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(new File(filepath));
        } catch (UnmarshalException exc) {
            logger.error("Файл не найден");
            System.out.println(exc.getMessage());
        } catch (JAXBException exc) {
            logger.error("Ошибка чтения файла");
        }
        return null;
    }

    @Override
    public void writeFile(String filepath, Object o) {
        try {
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(o, new File(filepath));
        } catch (NullPointerException exc) {
            logger.error("Файл не найден");
        } catch (JAXBException exc) {
            logger.error("Ошибка записи в файл");
        }
    }
}
