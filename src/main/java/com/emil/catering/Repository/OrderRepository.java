package com.emil.catering.Repository;

import com.emil.catering.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    @Modifying
    @Query(value = "INSERT INTO m_order (id, name, phone, order_date, order_for_date, time, qty, note) VALUES (:id ,:name, :phone, :orderDate, :orderForDate, :time, :qty, :note)", nativeQuery = true)
    void createOrder(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("orderDate") Date orderDate, @Param("orderForDate") Date orderForDate, @Param("time") LocalTime time, @Param("qty") Integer qty, @Param("note") String note);

    @Modifying
    @Query(value = "UPDATE m_order SET name = :name, phone = :phone, order_date = :orderDate, order_for_date = :orderForDate, time = :time, qty = :qty,  note = :note WHERE id = :id", nativeQuery = true)
    void updateOrder(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("orderDate") Date orderDate, @Param("orderForDate") Date orderForDate, @Param("time") LocalTime time, @Param("qty") Integer qty, @Param("note") String note);

    @Query(value = "SELECT * FROM m_order WHERE id = :id", nativeQuery = true)
    Optional<Order> findOrder(@Param("id") String id);

    @Query(value = "SELECT * FROM m_order", nativeQuery = true)
    List<Order> findAllOrder();
}
