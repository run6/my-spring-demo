package com.idanchuang.shop.user.sys.entity;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author mr
 * @since 2019-11-14
 */
@Data
@Accessors(chain = true)
public class UserAddresses {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String province;

    private String city;

    private String district;

    private String address;

    private Integer zip;

    private String contactName;

    private String contactPhone;

    private LocalDateTime lastUsedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
