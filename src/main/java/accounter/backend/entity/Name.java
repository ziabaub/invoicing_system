
package accounter.backend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "name"
})
public class Name {

    @JsonProperty("title")
    private String title;
    @JsonProperty("first")
    private String name;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("first")
    public String getName() {
        return name;
    }

    @JsonProperty("first")
    public void setName(String name) {
        this.name = name;
    }

}
