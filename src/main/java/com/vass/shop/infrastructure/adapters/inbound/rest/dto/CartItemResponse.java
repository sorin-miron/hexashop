package com.vass.shop.infrastructure.adapters.inbound.rest.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.vass.shop.infrastructure.adapters.inbound.rest.dto.ProductResponse;
import java.math.BigDecimal;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CartItemResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-08T15:51:02.639518700+03:00[Europe/Bucharest]", comments = "Generator version: 7.23.0")
public class CartItemResponse {

  private ProductResponse product;

  private Integer quantity;

  private BigDecimal subTotal;

  public CartItemResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CartItemResponse(ProductResponse product, Integer quantity, BigDecimal subTotal) {
    this.product = product;
    this.quantity = quantity;
    this.subTotal = subTotal;
  }

  public CartItemResponse product(ProductResponse product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
   */
  @NotNull @Valid 
  @Schema(name = "product", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("product")
  public ProductResponse getProduct() {
    return product;
  }

  @JsonProperty("product")
  public void setProduct(ProductResponse product) {
    this.product = product;
  }

  public CartItemResponse quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
   */
  @NotNull 
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  @JsonProperty("quantity")
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public CartItemResponse subTotal(BigDecimal subTotal) {
    this.subTotal = subTotal;
    return this;
  }

  /**
   * Get subTotal
   * @return subTotal
   */
  @NotNull @Valid 
  @Schema(name = "subTotal", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("subTotal")
  public BigDecimal getSubTotal() {
    return subTotal;
  }

  @JsonProperty("subTotal")
  public void setSubTotal(BigDecimal subTotal) {
    this.subTotal = subTotal;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartItemResponse cartItemResponse = (CartItemResponse) o;
    return Objects.equals(this.product, cartItemResponse.product) &&
        Objects.equals(this.quantity, cartItemResponse.quantity) &&
        Objects.equals(this.subTotal, cartItemResponse.subTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, quantity, subTotal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartItemResponse {\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    subTotal: ").append(toIndentedString(subTotal)).append("\n");
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

