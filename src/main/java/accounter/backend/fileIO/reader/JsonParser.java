package accounter.backend.fileIO.reader;

import accounter.backend.entity.InvoiceList;
import accounter.backend.exceptions.AccountantException;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class JsonParser {

    public InvoiceList parse(String fileName) throws AccountantException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new AccountantException("file not found");
        }
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(new File(resource.getFile()))) {
            return gson.fromJson(reader, InvoiceList.class);
        } catch (Exception e) {
            throw new AccountantException(e.getMessage(), e);
        }

    }
}
