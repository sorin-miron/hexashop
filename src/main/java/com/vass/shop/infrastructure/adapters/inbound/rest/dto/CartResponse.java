package com.vass.shop.infrastructure.adapters.inbound.rest.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vass.shop.infrastructure.adapters.inbound.rest.dto.CartItemResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CartResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-09T17:26:00.241978700+03:00[Europe/Bucharest]", comments = "Generator version: 7.23.0")
public class CartResponse {

  private UUID id;

  private UUID userId;

  /**
   * Gets or Sets cartType
   */
  public enum CartTypeEnum {
    NORMAL("NORMAL"),
    
    VIP("VIP");

    private final String value;

    CartTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CartTypeEnum fromValue(String value) {
      for (CartTypeEnum b : CartTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private CartTypeEnum cartType;

  private List<@Valid CartItemResponse> items = new ArrayList<>();

  private BigDecimal rawSubTotal;

  private BigDecimal finalTotal;

  private BigDecimal discountApplied;

  private Boolean checkedOut;

  public CartResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CartResponse(UUID id, UUID userId, CartTypeEnum cartType, List<@Valid CartItemResponse> items, BigDecimal rawSubTotal, BigDecimal finalTotal, BigDecimal discountApplied, Boolean checkedOut) {
    this.id = id;
    this.userId = userId;
    this.cartType = cartType;
    this.items = items;
    this.rawSubTotal = rawSubTotal;
    this.finalTotal = finalTotal;
    this.discountApplied = discountApplied;
    this.checkedOut = checkedOut;
  }

  public CartResponse id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(UUID id) {
    this.id = id;
  }

  public CartResponse userId(UUID userId) {
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

  public CartResponse cartType(CartTypeEnum cartType) {
    this.cartType = cartType;
    return this;
  }

  /**
   * Get cartType
   * @return cartType
   */
  @NotNull 
  @Schema(name = "cartType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cartType")
  public CartTypeEnum getCartType() {
    return cartType;
  }

  @JsonProperty("cartType")
  public void setCartType(CartTypeEnum cartType) {
    this.cartType = cartType;
  }

  public CartResponse items(List<@Valid CartItemResponse> items) {
    this.items = items;
    return this;
  }

  public CartResponse addItemsItem(CartItemResponse itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
   */
  @NotNull @Valid 
  @Schema(name = "items", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("items")
  public List<@Valid CartItemResponse> getItems() {
    return items;
  }

  @JsonProperty("items")
  public void setItems(List<@Valid CartItemResponse> items) {
    this.items = items;
  }

  public CartResponse rawSubTotal(BigDecimal rawSubTotal) {
    this.rawSubTotal = rawSubTotal;
    return this;
  }

  /**
   * Get rawSubTotal
   * @return rawSubTotal
   */
  @NotNull @Valid 
  @Schema(name = "rawSubTotal", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("rawSubTotal")
  public BigDecimal getRawSubTotal() {
    return rawSubTotal;
  }

  @JsonProperty("rawSubTotal")
  public void setRawSubTotal(BigDecimal rawSubTotal) {
    this.rawSubTotal = rawSubTotal;
  }

  public CartResponse finalTotal(BigDecimal finalTotal) {
    this.finalTotal = finalTotal;
    return this;
  }

  /**
   * Get finalTotal
   * @return finalTotal
   */
  @NotNull @Valid 
  @Schema(name = "finalTotal", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("finalTotal")
  public BigDecimal getFinalTotal() {
    return finalTotal;
  }

  @JsonProperty("finalTotal")
  public void setFinalTotal(BigDecimal finalTotal) {
    this.finalTotal = finalTotal;
  }

  public CartResponse discountApplied(BigDecimal discountApplied) {
    this.discountApplied = discountApplied;
    return this;
  }

  /**
   * Get discountApplied
   * @return discountApplied
   */
  @NotNull @Valid 
  @Schema(name = "discountApplied", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("discountApplied")
  public BigDecimal getDiscountApplied() {
    return discountApplied;
  }

  @JsonProperty("discountApplied")
  public void setDiscountApplied(BigDecimal discountApplied) {
    this.discountApplied = discountApplied;
  }

  public CartResponse checkedOut(Boolean checkedOut) {
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
    CartResponse cartResponse = (CartResponse) o;
    return Objects.equals(this.id, cartResponse.id) &&
        Objects.equals(this.userId, cartResponse.userId) &&
        Objects.equals(this.cartType, cartResponse.cartType) &&
        Objects.equals(this.items, cartResponse.items) &&
        Objects.equals(this.rawSubTotal, cartResponse.rawSubTotal) &&
        Objects.equals(this.finalTotal, cartResponse.finalTotal) &&
        Objects.equals(this.discountApplied, cartResponse.discountApplied) &&
        Objects.equals(this.checkedOut, cartResponse.checkedOut);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, cartType, items, rawSubTotal, finalTotal, discountApplied, checkedOut);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    cartType: ").append(toIndentedString(cartType)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    rawSubTotal: ").append(toIndentedString(rawSubTotal)).append("\n");
    sb.append("    finalTotal: ").append(toIndentedString(finalTotal)).append("\n");
    sb.append("    discountApplied: ").append(toIndentedString(discountApplied)).append("\n");
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

