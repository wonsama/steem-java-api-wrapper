package eu.bittrade.libs.steemj.protocol.operations.virtual;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steemj.enums.PrivateKeyType;
import eu.bittrade.libs.steemj.enums.ValidationType;
import eu.bittrade.libs.steemj.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steemj.interfaces.SignatureObject;
import eu.bittrade.libs.steemj.protocol.AccountName;
import eu.bittrade.libs.steemj.protocol.Asset;
import eu.bittrade.libs.steemj.protocol.operations.Operation;

/**
 * This class represents a Steem "interest_operation" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class InterestOperation extends Operation {
    @JsonProperty("owner")
    private AccountName owner;
    @JsonProperty("interest")
    private Asset interest;

    /**
     * This operation is a virtual one and can only be created by the blockchain
     * itself. Due to that, this constructor is private.
     */
    private InterestOperation() {
        super(true);
    }

    /**
     * @return The owner.
     */
    public AccountName getOwner() {
        return owner;
    }

    /**
     * @return The interest.
     */
    public Asset getInterest() {
        return interest;
    }

    @Override
    public byte[] toByteArray() throws SteemInvalidTransactionException {
        // The byte representation is not needed for virtual operations as we
        // can't broadcast them.
        return new byte[0];
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public Map<SignatureObject, PrivateKeyType> getRequiredAuthorities(
            Map<SignatureObject, PrivateKeyType> requiredAuthoritiesBase) {
        // A virtual operation can't be created by the user, therefore it also
        // does not require any authority.
        return null;
    }

    @Override
    public void validate(ValidationType validationType) {
        // There is no need to validate virtual operations.
    }
}
