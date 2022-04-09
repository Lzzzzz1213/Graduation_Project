package com.glasssellmanagersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPackage {
    private int productPackage_id;
    private String productPackage_name;
    private float productPackage_price;
    private String productPackage_describe;
    private String productPackage_createDate;
    private String productPackage_number;
}
