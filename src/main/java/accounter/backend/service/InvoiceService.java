package accounter.backend.service;

import accounter.backend.entity.Invoice;
import accounter.backend.singelton.data.SingletonResources;

import java.util.List;

public class InvoiceService {
    List<Invoice> invoices = SingletonResources.getInstance().getInvoices();
    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }
}
