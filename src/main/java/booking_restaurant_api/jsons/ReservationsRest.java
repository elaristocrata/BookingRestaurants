package booking_restaurant_api.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationsRest {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("locator")
    private String locator;
    @JsonProperty("turn")
    private String turn;
    @JsonProperty("person")
    private Long person;
    @JsonProperty("date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
