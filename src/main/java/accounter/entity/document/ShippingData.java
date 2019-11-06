
package accounter.entity.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "shipNumber",
        "salesRep",
        "shipDate",
        "shipVia",
        "terms",
        "dueDate"
})
public class ShippingData {

    @JsonProperty("shipNumber")
    private String shipNumber;
    @JsonProperty("salesRep")
    private String salesRep;
    @JsonProperty("shipDate")
    private String shipDate;
    @JsonProperty("shipVia")
    private String shipVia;
    @JsonProperty("terms")
    private String terms;
    @JsonProperty("dueDate")
    private String dueDate;

    @JsonProperty("shipNumber")
    public String getShipNumber() {
        return shipNumber;
    }

    @JsonProperty("shipNumber")
    public void setShipNumber(String shipNumber) {
        this.shipNumber = shipNumber;
    }

    @JsonProperty("salesRep")
    public String getSalesRep() {
        return salesRep;
    }

    @JsonProperty("salesRep")
    public void setSalesRep(String salesRep) {
        this.salesRep = salesRep;
    }

    @JsonProperty("shipDate")
    public String getShipDate() {
        return shipDate;
    }

    @JsonProperty("shipDate")
    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    @JsonProperty("shipVia")
    public String getShipVia() {
        return shipVia;
    }

    @JsonProperty("shipVia")
    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }

    @JsonProperty("terms")
    public String getTerms() {
        return terms;
    }

    @JsonProperty("terms")
    public void setTerms(String terms) {
        this.terms = terms;
    }

    @JsonProperty("dueDate")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("dueDate")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
