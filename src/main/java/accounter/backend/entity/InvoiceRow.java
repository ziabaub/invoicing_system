
package accounter.backend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "productId",
        "description",
        "quantity",
        "unitPrice"
})
public class InvoiceRow {

    @JsonProperty("productId")
    private String productId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("unitPrice")
    private double unitPrice;
    @JsonProperty("total")
    private double total;


    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("quantity")
    public int getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("unitPrice")
    public double getUnitPrice() {
        return unitPrice;
    }

    @JsonProperty("unitPrice")
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @JsonProperty("total")
    public double getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(double total) {
        this.total = total;
    }

}
