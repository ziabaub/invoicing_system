
package accounter.backend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "invoices"
})
public class InvoiceList {

    @JsonProperty("invoices")
    private List<Invoice> invoices = new ArrayList<>();

    @JsonProperty("invoices")
    public List<Invoice> getInvoices() {
        return invoices;
    }

    @JsonProperty("invoices")
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }


}
