package accounter.file.writer;

import accounter.entity.document.InvoiceList;
import accounter.exceptions.AccountantException;
import com.google.gson.Gson;

import java.io.*;
import java.net.URL;

public class JsonWriter {
    public void write(InvoiceList list, String fileName) throws AccountantException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new AccountantException("exception during write file ");
        }
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(new File(resource.getFile()))) {
            gson.toJson(list, writer);
        } catch (Exception e) {
            throw new AccountantException(e.getMessage(), e);
        }
    }
}
