package com.vass.shop.infrastructure.adapters.inbound.rest.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-09T17:26:00.241978700+03:00[Europe/Bucharest]", comments = "Generator version: 7.23.0")
public class CheckoutResponse {

  private UUID orderId;

  private Boolean checkedOut;

  public CheckoutResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CheckoutResponse(UUID orderId, Boolean checkedOut) {
    this.orderId = orderId;
    this.checkedOut = checkedOut;
  }

  public CheckoutResponse orderId(UUID orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
   */
  @NotNull @Valid 
  @Schema(name = "orderId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("orderId")
  public UUID getOrderId() {
    return orderId;
  }

  @JsonProperty("orderId")
  public void setOrderId(UUID orderId) {
    this.orderId = orderId;
  }

  public CheckoutResponse checkedOut(Boolean checkedOut) {
    this.checkedOut = checkedOut;
    return this;
  }

  /**
   * Get checkedOut
   * @return checkedOut
   */
  @NotNull 
  @Schema(name = "checkedOut", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("checkedOut")
  public Boolean getCheckedOut() {
    return checkedOut;
  }

  @JsonProperty("checkedOut")
  public void setCheckedOut(Boolean checkedOut) {
    this.checkedOut = checkedOut;
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
        Objects.equals(this.checkedOut, checkoutResponse.checkedOut);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, checkedOut);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutResponse {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    checkedOut: ").append(toIndentedString(checkedOut)).append("\n");
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

