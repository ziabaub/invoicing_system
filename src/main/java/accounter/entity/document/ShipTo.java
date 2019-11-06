
package accounter.entity.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sameAsBilling"
})
public class ShipTo {

    @JsonProperty("sameAsBilling")
    private Boolean sameAsBilling;

    @JsonProperty("sameAsBilling")
    public Boolean getSameAsBilling() {
        return sameAsBilling;
    }

    @JsonProperty("sameAsBilling")
    public void setSameAsBilling(Boolean sameAsBilling) {
        this.sameAsBilling = sameAsBilling;
    }

}
