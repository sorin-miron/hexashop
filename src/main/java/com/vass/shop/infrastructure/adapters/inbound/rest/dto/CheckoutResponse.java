package com.vass.shop.infrastructure.adapters.inbound.rest.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CheckoutResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-08T15:51:02.639518700+03:00[Europe/Bucharest]", comments = "Generator version: 7.23.0")
public class CheckoutResponse {

  private @Nullable UUID orderId;

  private UUID cartId;

  private UUID userId;

  private BigDecimal finalAmountPaid;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime purchaseTimestamp;

  private @Nullable String status;

  public CheckoutResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CheckoutResponse(UUID cartId, UUID userId, BigDecimal finalAmountPaid, OffsetDateTime purchaseTimestamp) {
    this.cartId = cartId;
    this.userId = userId;
    this.finalAmountPaid = finalAmountPaid;
    this.purchaseTimestamp = purchaseTimestamp;
  }

  public CheckoutResponse orderId(@Nullable UUID orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
   */
  @Valid 
  @Schema(name = "orderId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orderId")
  public @Nullable UUID getOrderId() {
    return orderId;
  }

  @JsonProperty("orderId")
  public void setOrderId(@Nullable UUID orderId) {
    this.orderId = orderId;
  }

  public CheckoutResponse cartId(UUID cartId) {
    this.cartId = cartId;
    return this;
  }

  /**
   * Get cartId
   * @return cartId
   */
  @NotNull @Valid 
  @Schema(name = "cartId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cartId")
  public UUID getCartId() {
    return cartId;
  }

  @JsonProperty("cartId")
  public void setCartId(UUID cartId) {
    this.cartId = cartId;
  }

  public CheckoutResponse userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   */
  @NotNull @Valid 
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public UUID getUserId() {
    return userId;
  }

  @JsonProperty("userId")
  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public CheckoutResponse finalAmountPaid(BigDecimal finalAmountPaid) {
    this.finalAmountPaid = finalAmountPaid;
    return this;
  }

  /**
   * Get finalAmountPaid
   * @return finalAmountPaid
   */
  @NotNull @Valid 
  @Schema(name = "finalAmountPaid", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("finalAmountPaid")
  public BigDecimal getFinalAmountPaid() {
    return finalAmountPaid;
  }

  @JsonProperty("finalAmountPaid")
  public void setFinalAmountPaid(BigDecimal finalAmountPaid) {
    this.finalAmountPaid = finalAmountPaid;
  }

  public CheckoutResponse purchaseTimestamp(OffsetDateTime purchaseTimestamp) {
    this.purchaseTimestamp = purchaseTimestamp;
    return this;
  }

  /**
   * Get purchaseTimestamp
   * @return purchaseTimestamp
   */
  @NotNull @Valid 
  @Schema(name = "purchaseTimestamp", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("purchaseTimestamp")
  public OffsetDateTime getPurchaseTimestamp() {
    return purchaseTimestamp;
  }

  @JsonProperty("purchaseTimestamp")
  public void setPurchaseTimestamp(OffsetDateTime purchaseTimestamp) {
    this.purchaseTimestamp = purchaseTimestamp;
  }

  public CheckoutResponse status(@Nullable String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public @Nullable String getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(@Nullable String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutResponse checkoutResponse = (CheckoutResponse) o;
    return Objects.equals(this.orderId, checkoutResponse.orderId) &&
        Objects.equals(this.cartId, checkoutResponse.cartId) &&
        Objects.equals(this.userId, checkoutResponse.userId) &&
        Objects.equals(this.finalAmountPaid, checkoutResponse.finalAmountPaid) &&
        Objects.equals(this.purchaseTimestamp, checkoutResponse.purchaseTimestamp) &&
        Objects.equals(this.status, checkoutResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, cartId, userId, finalAmountPaid, purchaseTimestamp, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutResponse {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    finalAmountPaid: ").append(toIndentedString(finalAmountPaid)).append("\n");
    sb.append("    purchaseTimestamp: ").append(toIndentedString(purchaseTimestamp)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

