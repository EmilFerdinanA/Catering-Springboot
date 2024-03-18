package com.emil.catering.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "m_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "order_date", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date orderDate;

    @Column(name = "order_for_date", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date orderForDate;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @Column(name = "note")
    private String note;
}
