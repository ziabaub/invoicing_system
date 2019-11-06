package accounter.singelton.data;

import accounter.entity.document.InvoiceList;

public class SingletonResources {
    private static InvoiceList list;

    private SingletonResources() {
    }

    public static void init(InvoiceList invoiceList) {
        if (list == null) {
            list = invoiceList;
        }
    }

    public static InvoiceList getInstance() {
        if (list ==null){
            list = new InvoiceList();
        }
        return list;
    }
}
