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
 * UserRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-09T17:26:00.241978700+03:00[Europe/Bucharest]", comments = "Generator version: 7.23.0")
public class UserRequest {

  private String username;

  private String email;

  private Boolean isVip;

  public UserRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserRequest(String username, String email, Boolean isVip) {
    this.username = username;
    this.email = email;
    this.isVip = isVip;
  }

  public UserRequest username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   */
  @NotNull @Pattern(regexp = "^[a-zA-Z0-9_]+$") @Size(min = 3, max = 50) 
  @Schema(name = "username", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  @JsonProperty("username")
  public void setUsername(String username) {
    this.username = username;
  }

  public UserRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  @NotNull @Size(max = 100) @Email
  @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  @JsonProperty("email")
  public void setEmail(String email) {
    this.email = email;
  }

  public UserRequest isVip(Boolean isVip) {
    this.isVip = isVip;
    return this;
  }

  /**
   * Get isVip
   * @return isVip
   */
  @NotNull 
  @Schema(name = "isVip", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("isVip")
  public Boolean getIsVip() {
    return isVip;
  }

  @JsonProperty("isVip")
  public void setIsVip(Boolean isVip) {
    this.isVip = isVip;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRequest userRequest = (UserRequest) o;
    return Objects.equals(this.username, userRequest.username) &&
        Objects.equals(this.email, userRequest.email) &&
        Objects.equals(this.isVip, userRequest.isVip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, email, isVip);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRequest {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    isVip: ").append(toIndentedString(isVip)).append("\n");
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

