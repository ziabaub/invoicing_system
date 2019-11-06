
package accounter.entity.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "invoiceHeader",
        "billTo",
        "shipTo",
        "shippingData",
        "notes",
        "invoiceRows"
})
public class Invoice {

    @JsonProperty("invoiceHeader")
    private InvoiceHeader invoiceHeader = new InvoiceHeader();
    @JsonProperty("billTo")
    private BillTo billTo = new BillTo();
    @JsonProperty("shipTo")
    private ShipTo shipTo = new ShipTo();
    @JsonProperty("shippingData")
    private ShippingData shippingData = new ShippingData();
    @JsonProperty("notes")
    private String notes ;
    @JsonProperty("invoiceRows")
    private List<InvoiceRow> invoiceRows = new ArrayList<>();


    @JsonProperty("invoiceHeader")
    public InvoiceHeader getInvoiceHeader() {
        return invoiceHeader;
    }

    @JsonProperty("invoiceHeader")
    public void setInvoiceHeader(InvoiceHeader invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    @JsonProperty("billTo")
    public BillTo getBillTo() {
        return billTo;
    }

    @JsonProperty("billTo")
    public void setBillTo(BillTo billTo) {
        this.billTo = billTo;
    }

    @JsonProperty("shipTo")
    public ShipTo getShipTo() {
        return shipTo;
    }

    @JsonProperty("shipTo")
    public void setShipTo(ShipTo shipTo) {
        this.shipTo = shipTo;
    }

    @JsonProperty("shippingData")
    public ShippingData getShippingData() {
        return shippingData;
    }

    @JsonProperty("shippingData")
    public void setShippingData(ShippingData shippingData) {
        this.shippingData = shippingData;
    }

    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonProperty("invoiceRows")
    public List<InvoiceRow> getInvoiceRows() {
        return invoiceRows;
    }

    @JsonProperty("invoiceRows")
    public void setInvoiceRows(List<InvoiceRow> invoiceRows) {
        this.invoiceRows = invoiceRows;
    }


}
