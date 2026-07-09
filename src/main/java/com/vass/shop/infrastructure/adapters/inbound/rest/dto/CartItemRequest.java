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
 * CartItemRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-09T23:19:45.189516700+03:00[Europe/Bucharest]", comments = "Generator version: 7.23.0")
public class CartItemRequest {

  private UUID productId;

  private Integer quantity;

  public CartItemRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CartItemRequest(UUID productId, Integer quantity) {
    this.productId = productId;
    this.quantity = quantity;
  }

  public CartItemRequest productId(UUID productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
   */
  @NotNull @Valid 
  @Schema(name = "productId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("productId")
  public UUID getProductId() {
    return productId;
  }

  @JsonProperty("productId")
  public void setProductId(UUID productId) {
    this.productId = productId;
  }

  public CartItemRequest quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * minimum: 1
   * maximum: 1000
   * @return quantity
   */
  @NotNull @Min(value = 1) @Max(value = 1000) 
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  @JsonProperty("quantity")
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartItemRequest cartItemRequest = (CartItemRequest) o;
    return Objects.equals(this.productId, cartItemRequest.productId) &&
        Objects.equals(this.quantity, cartItemRequest.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartItemRequest {\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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

