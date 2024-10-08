package com.insurance.system.shared.usermanagement.domain;

public enum PermissionsEnum {
  ADMIN_PASSWORD_POLICY_CREATE(UserType.ADMIN),
  ADMIN_PASSWORD_POLICY_DELETE(UserType.ADMIN),
  ADMIN_PASSWORD_POLICY_READ(UserType.ADMIN),
  ADMIN_PASSWORD_POLICY_UPDATE(UserType.ADMIN),
  ADMIN_USER_CREATE(UserType.ADMIN),
  ADMIN_USER_DELETE(UserType.ADMIN),
  ADMIN_USER_READ(UserType.ADMIN),
  ADMIN_USER_UPDATE(UserType.ADMIN),
  ADMIN_ALL_CREATE(UserType.ADMIN),
  ADMIN_ALL_DELETE(UserType.ADMIN),
  ADMIN_ALL_READ(UserType.ADMIN),
  ADMIN_ALL_UPDATE(UserType.ADMIN),
  RETAIL_BELONGS_TO_RETAIL_DEPT(UserType.RETAIL),
  RETAIL_POLICY_CREATE(UserType.RETAIL),
  RETAIL_POLICY_DELETE(UserType.RETAIL),
  RETAIL_POLICY_READ(UserType.RETAIL),
  RETAIL_POLICY_UPDATE(UserType.RETAIL),
  RETAIL_CLAIM_CREATE(UserType.RETAIL),
  RETAIL_CLAIM_DELETE(UserType.RETAIL),
  RETAIL_CLAIM_READ(UserType.RETAIL),
  RETAIL_CLAIM_UPDATE(UserType.RETAIL),
  RETAIL_ACCOUNTING_CREATE(UserType.RETAIL),
  RETAIL_ACCOUNTING_DELETE(UserType.RETAIL),
  RETAIL_ACCOUNTING_READ(UserType.RETAIL),
  RETAIL_ACCOUNTING_UPDATE(UserType.RETAIL);
  
  private final UserType userType;
  
  public UserType getUserType() {
    return this.userType;
  }
  
  PermissionsEnum(UserType userType) {
    this.userType = userType;
  }
}
