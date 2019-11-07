package accounter.backend.singelton.data;

import accounter.backend.entity.InvoiceList;
import accounter.backend.singelton.id.Id;

public class SingletonResources {
    private static InvoiceList list;

    private SingletonResources() {
    }

    public static void init(InvoiceList invoiceList) {
        if (list == null) {
            list = invoiceList;
            int len = invoiceList.getInvoices().size()-1;
            long counter = invoiceList.getInvoices().get(len).getInvoiceHeader().getInvoiceNumber();
            Id.init(counter);
        }
    }

    public static InvoiceList getInstance() {
        if (list ==null){
            list = new InvoiceList();
            Id.init(1000);
        }
        return list;
    }
}
