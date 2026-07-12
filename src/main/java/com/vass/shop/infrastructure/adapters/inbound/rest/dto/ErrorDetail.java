package com.vass.shop.infrastructure.adapters.inbound.rest.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ErrorDetail
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-12T14:09:38.843192700+03:00[Europe/Bucharest]", comments = "Generator version: 7.23.0")
public class ErrorDetail {

  private Integer code;

  private String message;

  private String timestamp;

  public ErrorDetail() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorDetail(Integer code, String message, String timestamp) {
    this.code = code;
    this.message = message;
    this.timestamp = timestamp;
  }

  public ErrorDetail code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * minimum: 400
   * maximum: 599
   * @return code
   */
  @NotNull @Min(value = 400) @Max(value = 599) 
  @Schema(name = "code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }

  @JsonProperty("code")
  public void setCode(Integer code) {
    this.code = code;
  }

  public ErrorDetail message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  @NotNull @Pattern(regexp = "^[a-zA-Z0-9 ]+$") @Size(min = 1, max = 255) 
  @Schema(name = "message", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorDetail timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
   */
  @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.*$") @Size(min = 1, max = 50) 
  @Schema(name = "timestamp", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timestamp")
  public String getTimestamp() {
    return timestamp;
  }

  @JsonProperty("timestamp")
  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDetail errorDetail = (ErrorDetail) o;
    return Objects.equals(this.code, errorDetail.code) &&
        Objects.equals(this.message, errorDetail.message) &&
        Objects.equals(this.timestamp, errorDetail.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDetail {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

