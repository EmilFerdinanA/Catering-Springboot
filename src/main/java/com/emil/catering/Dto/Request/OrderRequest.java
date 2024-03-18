package com.emil.catering.Dto.Request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private String id;
    private String name;
    private String phone;
    private Date orderDate;
    private Date orderForDate;
    private String time;
    private Integer qty;
    private String note;
}
