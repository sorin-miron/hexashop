package com.vass.shop.infrastructure.adapters.inbound.rest.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-08T15:51:02.639518700+03:00[Europe/Bucharest]", comments = "Generator version: 7.23.0")
public class UserRequest {

  private String username;

  /**
   * Gets or Sets userType
   */
  public enum UserTypeEnum {
    NORMAL("NORMAL"),
    
    VIP("VIP");

    private final String value;

    UserTypeEnum(String value) {
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
    public static UserTypeEnum fromValue(String value) {
      for (UserTypeEnum b : UserTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private UserTypeEnum userType;

  public UserRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserRequest(String username, UserTypeEnum userType) {
    this.username = username;
    this.userType = userType;
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

  public UserRequest userType(UserTypeEnum userType) {
    this.userType = userType;
    return this;
  }

  /**
   * Get userType
   * @return userType
   */
  @NotNull 
  @Schema(name = "userType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userType")
  public UserTypeEnum getUserType() {
    return userType;
  }

  @JsonProperty("userType")
  public void setUserType(UserTypeEnum userType) {
    this.userType = userType;
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
        Objects.equals(this.userType, userRequest.userType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, userType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRequest {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
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

