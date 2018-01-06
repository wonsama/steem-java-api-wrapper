package eu.bittrade.libs.steemj.plugins.apis.database.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joou.UInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steemj.plugins.apis.database.enums.SortOrderType;
import eu.bittrade.libs.steemj.util.SteemJUtils;

/**
 * This class represents a Steem "list_accounts_args" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class ListAccountsArgs {
    // TODO: Original type is "fc::variant".
    @JsonProperty("start")
    private Object start;
    @JsonProperty("limit")
    private UInteger limit;
    @JsonProperty("order")
    private SortOrderType order;

    /**
     * 
     * @param start
     * @param limit
     * @param order
     */
    public ListAccountsArgs(@JsonProperty("start") Object start, @JsonProperty("limit") UInteger limit,
            @JsonProperty("order") SortOrderType order) {
        this.setStart(start);
        this.setLimit(limit);
        this.setOrder(order);
    }

    /**
     * @return the start
     */
    public Object getStart() {
        return start;
    }

    /**
     * @param start
     *            the start to set
     */
    public void setStart(Object start) {
        this.start = SteemJUtils.setIfNotNull(start, "The start needs to be provided.");
    }

    /**
     * @return the limit
     */
    public UInteger getLimit() {
        return limit;
    }

    /**
     * @param limit
     *            the limit to set
     */
    public void setLimit(UInteger limit) {
        this.limit = SteemJUtils.setIfNotNull(limit, "The limit needs to be provided.");
    }

    /**
     * @return the order
     */
    public SortOrderType getOrder() {
        return order;
    }

    /**
     * @param order
     *            the order to set
     */
    public void setOrder(SortOrderType order) {
        this.order = SteemJUtils.setIfNotNull(order, "The order needs to be provided.");
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
