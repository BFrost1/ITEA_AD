package homeWork.homeWork12;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Mapper {
    public Object getObject(File file, Class clazz) {
        Object obj = null;
        try {
            obj = JAXBContext.newInstance(clazz).createUnmarshaller().unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
