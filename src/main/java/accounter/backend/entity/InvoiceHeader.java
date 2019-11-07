
package accounter.backend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "invoiceDate",
        "invoiceNumber"
})
public class InvoiceHeader {

    @JsonProperty("invoiceDate")
    private String invoiceDate;
    @JsonProperty("invoiceNumber")
    private long invoiceNumber;

    @JsonProperty("invoiceDate")
    public String getInvoiceDate() {
        return invoiceDate;
    }

    @JsonProperty("invoiceDate")
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @JsonProperty("invoiceNumber")
    public long getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("invoiceNumber")
    public void setInvoiceNumber(long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

}
